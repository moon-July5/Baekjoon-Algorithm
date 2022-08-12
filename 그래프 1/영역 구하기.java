import java.io.*;
import java.util.*;


/*   Baekjoon 2583번 - 영역 구하기 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 12
*    메모리 : 15984 KB
*    시간 : 160 ms
 */

public class Main {
    private static int M, N, K; // 모눈종이의 세로, 가로 크기, 직사각형의 개수
    private static boolean[][] visited; // 방문 표시
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1 ,0};
    private static int count = 0; // 분리되어 나누어지는 영역의 개수
    private static ArrayList<Integer> list = new ArrayList<>(); // 각 영역의 넓이를 저장할 공간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        // 모눈종이에서 직사각형 좌표 입력
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 주어진 직사각형 좌표를 이용하여 모눈종이에 1로 표시
            for(int i=y1; i<y2; i++){
                for(int j=x1; j<x2; j++){
                    arr[i][j] = 1;
                }
            }
        }

        // BFS 탐색
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                // 방문하지 않았고 직사각형 내부가 아니라면
                if(!visited[i][j] && arr[i][j]==0){
                    bfs(i, j);
                    count++;
                }
            }
        }

        bw.write(count+"\n"); // 영역의 개수 출력

        Collections.sort(list); // 각 영역의 넓이를 오름차순으로 정렬

        for(int val : list)
            bw.write(val+" "); // 오름차순으로 정렬된 넓이를 출력
        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 탐색
    public static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b}); // 좌표, 각 영역의 넓이

        int area = 1;

        visited[a][b] = true;

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            for(int i=0; i<4; i++){
                int y = node[0] + dy[i];
                int x = node[1] + dx[i];

                // 모눈종이 영역 안에서만 탐색
                if(x>=0 && y>=0 && x<N && y<M){
                    // 방문하지 않았고 직사각형 내부가 아니면
                    if(!visited[y][x] && arr[y][x]==0){
                        visited[y][x] = true; // 방문 표시
                        area += 1; // 각 영역의 넓이 count
                        queue.add(new int[] {y, x}); // 다음에 이동할 좌표 저장
                    }
                }
            }
        }
        list.add(area); // 각 영역의 넓이 저장
    }
}

