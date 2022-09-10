import java.io.*;

/*   Baekjoon 17626번 - Four Squares (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 10
*    메모리 : 15332 KB
*    시간 : 152 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 자연수

        int[] dp = new int[N+1]; // 인덱스 N까지 최소 제곱수의 합을 저장

        dp[1] = 1; // 초기값

        for(int i=2; i<=N; i++){
            int min = Integer.MAX_VALUE;

            for(int j=1; j*j<=i; j++){
                int val = i - j * j; // i - (제곱수)
                min = Math.min(min, dp[val]);
            }

            dp[i] = min + 1;
        }

        bw.write(dp[N]+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



