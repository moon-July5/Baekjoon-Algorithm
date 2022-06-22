import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 2225번 - 합분해 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 22
*    메모리 : 14628 KB
*    시간 : 140 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정수 N
        int K = Integer.parseInt(st.nextToken()); // 0 ~ N 까지 선택할 개수

        // dp[N][K] = N을 만들기 위해 정수 K개 가지고 만드는 경우의 수
        long[][] dp = new long[201][201];

        for(int i=1; i<=K; i++)
            dp[0][i] = 1;


        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        bw.write(dp[N][K]+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

