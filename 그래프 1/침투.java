import java.io.*;
import java.util.*;


/*   Baekjoon 13565번 - 침투 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 10
*    메모리 : 59764 KB
*    시간 : 412 ms
 */

public class Main {
    private static int M, N; // 격자판의 세로, 가로 크기
    private static int[][] arr;
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1 ,0, -1, 0};
    private static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        // 입력
        for(int i=0; i<M; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        // outer side에서 전류를 흘려보내야 하기 때문에 첫 행에서만 탐색하도록 한다.
        for(int i=0; i<N; i++){
            if(arr[0][i] == 0){ // 전류가 통하면
                dfs(0, i);
            }
        }

        if(flag) bw.write("YES");
        else bw.write("NO");

        bw.flush();

        bw.close();
        br.close();
    }
    // DFS 방식
    public static void dfs(int a, int b) {
        visited[a][b] = true;

        if(a == M-1){ // 전류가 inner side까지 도착하면
            flag = true; // true로 변환
            return;
        }

        for(int i=0; i<4; i++){
            int y = a + dy[i];
            int x = b + dx[i];

            // 전류가 M X N 격자의 범위 안에서만 움직이도로 하고
            if(x>=0 && y>=0 && x<N && y<M){
                // 방문하지 않았고 전류가 통하면
                if(!visited[y][x] && arr[y][x]==0){
                    dfs(y, x);
                }
            }
        }
    }
}

