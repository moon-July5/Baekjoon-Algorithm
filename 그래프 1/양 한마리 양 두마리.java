import java.io.*;
import java.util.*;


/*   Baekjoon 11123번 - 양 한마리... 양 두마리... (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 12
*    메모리 : 27532 KB
*    시간 : 300 ms
 */

public class Main {
    private static int N, M; // 그리드의 높이, 너비
    private static char[][] arr;
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new char[N][M];
            visited = new boolean[N][M];

            // 그리드 입력
            for(int i=0; i<N; i++){
                String s = br.readLine();
                for(int j=0; j<M; j++){
                    arr[i][j] = s.charAt(j);
                }
            }

            int count = 0;

            // BFS 탐색
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    // 방문하지 않았고 양이라면
                    if(!visited[i][j] && arr[i][j]=='#'){
                        bfs(i, j); // BFS 탐색
                        count++; // 탐색 후 양의 무리를 count
                    }
                }
            }

            bw.write(count + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 탐색
    public static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});

        visited[a][b] = true;

        while (!queue.isEmpty()){
            int[] node = queue.poll();

            for(int i=0; i<4; i++){
                int y = node[0] + dy[i];
                int x = node[1] + dx[i];

                // 그리드의 범위 안에서만 이동할 수 있고
                if(x>=0 && y>=0 && x<M && y<N){
                    // 방문하지 않았으며, 양이라면
                    if(!visited[y][x] && arr[y][x]=='#'){
                        visited[y][x] = true; // 방문 표시
                        queue.add(new int[] {y, x});
                    }
                }
            }
        }
    }

}

