import java.io.*;
import java.util.*;

/*   Baekjoon 2146번 - 다리 만들기 (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 28
*    메모리 : 138804 KB
*    시간 : 296 ms
 */
public class Main {
    private static int N;   // 지도의 크기
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};    // x축 이동
    private static int[] dy = {1, 0, -1, 0};    // y축 이동
    private static int[][] arr;
    private static Queue<int[]> queue = new LinkedList<>();
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        islandDivide();  // 섬 구분하기

        int min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]>0){
                    visited = new boolean[N][N];
                    answer = bfs(i,j);

                    if(answer != -1 && min > answer)
                        min = answer;
                }
            }
        }

        bw.write(min-1+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 방식으로 섬 구분
    public static void islandDivide(){
        // 섬을 번호로 구분한다.
        int island = 2;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && arr[i][j]!=0){
                    visited[i][j] = true;
                    arr[i][j] = island;
                    queue.add(new int[]{i, j, 0});

                    while(!queue.isEmpty()){
                        int[] node = queue.poll();

                        for(int k=0; k<4; k++){
                            int y = node[0] + dy[k];
                            int x = node[1] + dx[k];

                            // 지도 크기인 N*N 범위 안에만 이동할 수 있으며
                            if(x>=0 && y>=0 && x<N && y<N){
                                // 노드에 방문한 적이 없고 육지면
                                if(!visited[y][x] && arr[y][x] == 1){
                                    visited[y][x] = true;
                                    arr[y][x] = island;
                                    queue.add(new int[] {y, x, 0});
                                }

                            }
                        }
                    }
                    // 한 섬을 구분했다면 다음 섬을 구분할 때는 다른 번호로 구분
                    island++;
                }
            }
        }
    }

    // 다리의 최소 개수 세기
    public static int bfs(int a, int b) {
        queue = new LinkedList<>();

        int n = arr[a][b];

        visited[a][b] = true;
        queue.add(new int[] {a, b, 0});

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            // 이동할 위치가 바다가 아니고 현재 섬의 육지가 아니라면 count 반환
            if(arr[node[0]][node[1]] != 0 && arr[node[0]][node[1]] != n){
                return node[2];
            }

            for(int i=0; i<4; i++){
                int y = node[0] + dy[i];
                int x = node[1] + dx[i];

                // 지도 크기인 N*N 범위 안에만 이동할 수 있으며
                if(x>=0 && y>=0 && x<N && y<N){
                    // 방문한 적이 없고 현재 섬의 육지가 이니면
                    if(!visited[y][x] && arr[y][x] != n){
                        visited[y][x] = true;
                        queue.add(new int[] {y, x, node[2]+1});
                    }
                }

            }
        }
        return -1;
    }
}

