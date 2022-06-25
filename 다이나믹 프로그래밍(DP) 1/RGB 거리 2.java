import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 17404번 - RGB 거리 2 (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 25
*    메모리 : 14640 KB
*    시간 : 144 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 집의 수

        // [N][0]:red, [N][1]:green, [N][2]:blue
        int[][] rgb = new int[N][3];
        int[][] dp = new int[N][3];

        // 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = 1000*1000;

        // 첫 번째 집을 칠하는 경우
        for(int i=0; i<3; i++){
            // red, green, blue 로 칠하는 경우 칠한 색을 제외한 나머지는 최대 비용 값으로 저장
            for(int j=0; j<3; j++){
                if(i==j) dp[0][j] = rgb[0][j];
                else dp[0][j] = 1000*1000;
            }

            // 0:red, 1:green, 2:blue 로 칠했을 때, 최소 비용
            for(int j=1; j<N; j++){
                dp[j][0] = rgb[j][0] + Math.min(dp[j-1][1], dp[j-1][2]);
                dp[j][1] = rgb[j][1] + Math.min(dp[j-1][0], dp[j-1][2]);
                dp[j][2] = rgb[j][2] + Math.min(dp[j-1][0], dp[j-1][1]);
            }

            // 최소 비용을 구하는 부분
            for(int j=0; j<3; j++) {
                if (i != j && min > dp[N-1][j]) {
                    min = dp[N-1][j];
                }
            }
        }

        bw.write(min+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

