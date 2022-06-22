import java.io.*;

/*   Baekjoon 1699번 - 제곱수의 합 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 22
*    메모리 : 15432 KB
*    시간 : 180 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[1] = 1;

        for(int i=2; i<N+1; i++) {
            // 초기값
            dp[i] = i;

            /*
                1 ~ i 까지 제곱수를 찾는다.
                (i-제곱수) 최소 항의 개수 + 1을 통해 계산한다. 
             */
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        bw.write(dp[N]+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

