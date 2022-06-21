import java.io.*;

/*   Baekjoon 2193번 - 이친수 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 21
*    메모리 : 14296 KB
*    시간 : 132 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 최대 90자리의 이친수 개수를 구하는 것이기 때문에 long형으로 선언한다.
        long[] dp = new long[N+1];

        for(int i=1; i<N+1; i++){
            // 1 자리와 2 자리의 이친수 개수는 1개이다.
            if(i<=2) dp[i] = 1;
            else { // 3부터 이친수의 개수는 i-2번째와 i-1번째의 개수이다.
                dp[i] = dp[i-2] + dp[i-1];
            }
        }

        bw.write(dp[N]+"");

        bw.close();
        br.close();
    }


}

