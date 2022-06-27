import java.io.*;
import java.util.*;

/*   Baekjoon 2178번 - 미로 탐색 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 27
*    메모리 : 103328 KB
*    시간 : 784 ms
 */
public class Main {
    private static int N, M; // 세로, 가로
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};    // x축 이동
    private static int[] dy = {1, 0, -1, 0};    // y축 이동
    private static int[][] arr;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        // 입력
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        // 미로 탐색
        bfs(0,0);

        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 방식
    private static void bfs(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b, 1}); // y 좌표, x 좌표, 이동거리

        visited[a][b] = true;

        // 탐색
        while (!queue.isEmpty()){
            int[] q = queue.poll();

            // 목적지인 (N,M) 위치에 도착했으면
            if(q[0]==N-1 && q[1]==M-1){
                count = q[2];
                break;
            }

            for(int i=0; i<4; i++){
                int y = q[0] + dy[i]; // y축 이동
                int x = q[1] + dx[i]; // x축 이동

                // N*M 크기의 미로 안에서만 이동
                if(x>=0 && y>=0 && x<M && y<N){
                    // 방문한 적이 없고 이동할 수 있는 칸 이여야 함
                    if(!visited[y][x] && arr[y][x]==1){
                        // y 좌표, x 좌표, 이동거리+1
                        queue.add(new int[] {y, x, q[2]+1});
                        visited[y][x] = true;
                    }
                }
            }
        }
    }

}

