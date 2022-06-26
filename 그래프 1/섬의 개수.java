import java.io.*;
import java.util.*;

/*   Baekjoon 4963번 - 섬의 개수 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 26
*    메모리 : 16544 KB
*    시간 : 200 ms
 */
public class Main {
    private static int w,h; // 지도의 너비와 높이
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};   // 8방향 x 축
    private static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};   // 8방향 y 축
    private static int[][] arr;
    private static int land; // 섬의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 종료
            if(w==0 && h==0) break;

            arr = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            land = 0;

            // 탐색
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && arr[i][j]==1){
                        bfs(i,j);
                        land++;
                    }
                }
            }
            bw.write(land+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 방식
    public static void bfs(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});

        visited[a][b] = true;

        // 인접한 노드 탐색
        while(!queue.isEmpty()){
            int[] q = queue.poll();

            // 8 방향 탐색
            for(int i=0; i<8; i++){
                int y = q[0] + dy[i];
                int x = q[1] + dx[i];

                // w*h 범위안에만 이동할 수 있어야 하며
                if(x>=0 && y>=0 && x<w && y<h){
                    // 이동한 노드에 방문한 적이 없고 땅이면
                    if(!visited[y][x] && arr[y][x]==1){
                        // 이동한 노드의 좌표를 Queue 에 저장
                        queue.add(new int[]{y, x});
                        // 방문 표시
                        visited[y][x] = true;
                    }
                }
            }
        }
    }
}

