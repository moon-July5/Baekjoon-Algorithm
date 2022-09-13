import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 14620번 - 꽃길 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 13
*    메모리 : 18436 KB
*    시간 : 204 ms
 */

public class Main {
    private static int N; // 화단의 한 변의 길이
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1}; // x축 이동
    private static int[] dy = {-1, 0, 1, 0}; // y축 이동
    private static int answer = Integer.MAX_VALUE;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        // 화단의 지점당 가격 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0 ,0);

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    private static void solve(int count, int sum) {
        if(count==3){ // 씨앗을 3개 심었을 경우
            answer = Math.min(answer, sum); // 3개의 씨앗을 심었을 때, 총가격의 최솟값 갱신
            return;
        }

        // 3개의 씨앗 심기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && check(i, j)){
                    visited[i][j] = true;
                    int g = arr[i][j]; // 가격

                    // 4방향 탐색
                    for(int k=0; k<4; k++){
                        int y = i + dy[k];
                        int x = j + dx[k];

                        visited[y][x] = true; // 방문 표시
                        g += arr[y][x]; // 지점당 가격 누적해서 더한다.
                    }

                    solve(count+1, sum + g);

                    visited[i][j] = false; // 미방문 표시
                    reset(i, j); // 이동했던 곳 미방문 표시
                }
            }
        }
    }

    // 방문 표시 초기화 메서드/
    private static void reset(int a, int b){
        for(int i=0; i<4; i++){
            int y = a + dy[i];
            int x = b + dx[i];

            visited[y][x] = false;
        }
    }

    // 꽃밭의 범위 내에 이동과 방문 확인 메서드
    private static boolean check(int a, int b){
        for(int i=0; i<4; i++){
            int y = a + dy[i];
            int x = b + dx[i];

            if (y<0 || x<0 || y>=N || x>=N || visited[y][x]) {
                return false;
            }
        }

        return true;
    }


}



