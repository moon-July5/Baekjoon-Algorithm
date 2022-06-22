import java.io.*;

/*   Baekjoon 15988번 - 1, 2, 3 더하기 3 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 22
*    메모리 : 23824 KB
*    시간 : 176 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
        long[] dp = new long[1000001];

        /*
           9095번 - 1, 2, 3 더하기 참조
         */
        for(int i=1; i<dp.length; i++){
            if(i<=2) dp[i] = i;
            else if(i==3) dp[i] = 4;
            else {
                dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
            }
        }

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            bw.write(dp[n]%1000000009+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }


}

