import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 14500번 - 테트로미노 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 07 - 05
*    메모리 : 32664 KB
*    시간 : 692 ms
 */

public class Main {
    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 종이의 세로 크기
        M = Integer.parseInt(st.nextToken()); // 종이의 가로 크기

        arr = new int[N][M];
        visited = new boolean[N][M];

        // 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int a, int b, int sum, int count){
        // 테트로미노 완성
        if(count==4){
            max = Math.max(max, sum);
            return;
        }
        // 상, 하, 좌, 우 탐색
        for(int i=0; i<4; i++){
            int y = a + dy[i];
            int x = b + dx[i];

            // 범위 안에 있어야 하며
            if(x>=0 && y>=0 && x<M && y<N){
                // 아직 밭문하지 않았다면
                if(!visited[y][x]){
                    // 'ㅗ' 모양의 테트로미노를 만들기 위해 2번째 칸에서 탐색을 한번 더 진행
                    if(count==2){
                        visited[y][x] = true;
                        dfs(a,b, sum+arr[y][x], count+1);
                        visited[y][x] = false;
                    }

                    visited[y][x] = true;
                    dfs(y, x, sum+arr[y][x], count+1);
                    visited[y][x] = false;
                }
            }
        }

    }

}

