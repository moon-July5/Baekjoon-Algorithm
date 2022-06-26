import java.io.*;
import java.util.*;

/*   Baekjoon 2667번 - 단지번호붙이기 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 26
*    메모리 : 18364 KB
*    시간 : 204 ms
 */
public class Main {
    private static int N;     // 지도의 크기
    private static boolean[][] visited;  // 방문 표시
    private static int total = 0;   // 총 단지 수
    private static int count;    // 단지내 집의 수
    private static int[] dx = {0, 1, 0, -1};    // x축 이동
    private static int[] dy = {1, 0, -1, 0};    // y축 이동
    private static int[][] arr;
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && arr[i][j]==1){
                    count = 1;  // 단지 내 집의 수 초기 값
                    bfs(i,j);
                    total++;    // 총 단지 수 count
                    list.add(count);   // 단지 내 집의 수 저장
                }
            }
        }
        bw.write(total+"\n");

        // 단지 내 집의 수 오름차순 정렬
        Collections.sort(list);

        for(int val : list){
            bw.write(val+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 방식
    public static void bfs(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b}); // y축, x축

        // 방문 표시
        visited[a][b] = true;

        // 노드 탐색
        while(!queue.isEmpty()){
            int[] q = queue.poll();

            // 4 방향 탐색
            for(int i=0; i<4; i++){
                int y = q[0] + dy[i];
                int x = q[1] + dx[i];

                // 주어진 조건인 N*N 크기 지도 범위 안에 존재해야 하며
                if(x>=0 && y>=0 && x<N && y<N){
                    // 방문한 적이 없고 집이 있는 곳이면
                    if(!visited[y][x] && arr[y][x]==1){
                        queue.add(new int[] {y, x});
                        visited[y][x] = true;
                        count++; // 집의 개수를 세기 위한 count
                    }
                }
            }
        }
    }
}

