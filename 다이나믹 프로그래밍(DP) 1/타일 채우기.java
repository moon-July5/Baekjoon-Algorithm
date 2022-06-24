import java.io.*;

/*   Baekjoon 2133번 - 타일 채우기 (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 24
*    메모리 : 14432 KB
*    시간 : 128 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[0] = 1;

        // 3Xn 타일을 채우는데 n이 홀수일 경우, 타일을 채울 수 없다.
        // 따라서, 시작은 2부터 한다.
        for(int i=2; i<N+1; i+=2) {
            // 초기 값
            // 예를 들어, 3X2 타일을 채우는 경우 3 가지 경우의 수가 존재하며,
            // 3X4 타일을 채우는 경우 3X2 타일 두개를 합친 것과 같기 때문에 dp[2]*dp[2] = 9가지 경우의 수를 초기 값으로 한다.
            dp[i] = 3 * dp[i-2];

            for(int j=0; j<i-2; j+=2) {
                // 위의 기본적인 경우의 수 이외에 3X4 타일을 채우는 경우부터 예외 케이스가 추가적으로 존재
                // 예를 들어, 3X6 타일을 채우는 경우 (기본적인 경우의 수 + dp[2]*2 + 2) 이런 식으로 계산
                // 3X8 타일을 채우는 경우, (기본적인 경우의 수 + dp[4]*2 + dp[2]*2 + 2)
                dp[i] += dp[j] *2;
            }
        }

        bw.write(dp[N]+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

