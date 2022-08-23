import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1405번 - 미친 로봇 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 23
*    메모리 : 15408 KB
*    시간 : 208 ms
 */

public class Main {
    private static int N; // 행동 횟수
    private static double[] arr; // 동서남북으로 이동할 확률
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {1, -1, 0, 0}; // 동, 서, 남, 북 이동
    private static int[] dy = {0, 0, 1, -1}; // 동, 서, 남, 북 이동
    private static double answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new double[4];
        visited = new boolean[30][30]; // 시작점을 15, 15로

        // 동, 서, 남, 북으로 이동할 확률 입력
        for(int i=0; i<4; i++)
            arr[i] = Double.parseDouble(st.nextToken()) * 0.01;

        // DFS 탐색
        dfs(15, 15, 0, 1);

        bw.write(answer+"");

        bw.close();
        br.close();
    }

    // DFS 탐색
    public static void dfs(int a, int b, int count, double total) {
        // N번의 행동을 완료했으면
        if(count == N){
            answer += total;
            return;
        }

        visited[a][b] = true;

        // 동, 서, 남, 북 탐색
        for(int i=0; i<4; i++){
            int y = a + dy[i];
            int x = b + dx[i];

            // 평면 위에서만 이동할 수 있으며
            if(x>=0 && y>=0 && x<30 && y<30){
                // 방문한 적이 없으면
                if(!visited[y][x]){
                    visited[y][x] = true; // 방문 표시
                    dfs(y, x, count+1, total * arr[i]);
                    visited[y][x] = false; // 미방문 표시
                }
            }
        }

    }
}


