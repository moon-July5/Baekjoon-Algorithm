import java.io.*;
import java.util.*;

/*   Baekjoon 16929번 - Two Dots (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 27
*    메모리 : 14184 KB
*    시간 : 124 ms
 */
public class Main {
    private static int N, M; // 게임판의 세로, 가로 크기
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1}; // x축 이동
    private static int[] dy = {1, 0, -1, 0}; // y축 이동
    private static char[][] arr;
    private static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        // 입력
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        // cycle 탐색
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    dfs(i, j, -1, -1);
                }
            }
        }
        bw.write(answer? "Yes" : "No");
        bw.flush();

        bw.close();
        br.close();
    }
    // DFS 방식 (시작 지점, 비교 지점)
    public static void dfs(int y, int x, int by, int bx){
        // 종료
        if(answer) return;

        // 4방향 탐색
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 게임판의 크기의 범위 안에 있어야 하며, 한번 갔던 노드는 안됨
            if((nx>=0 && ny>=0 && nx<M && ny<N) && (bx!=nx || by!=ny)){
                // 또한 같은 문자여야 함
                if(arr[y][x] == arr[ny][nx]){
                    // 여기서 방문한 적이 있으면 cycle 이 존재
                    if(visited[ny][nx]){
                        answer = true;
                        return;
                    } else { // 방문한 적이 없으면 탐색
                        visited[ny][nx] = true;
                        dfs(ny, nx, y, x);
                    }
                }
            }

        }
    }
}

