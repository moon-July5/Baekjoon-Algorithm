import java.io.*;

/*   Baekjoon 10844번 - 쉬운 계단 수 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 21
*    메모리 : 14268 KB
*    시간 : 128 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 2차원 배열 선언
        // 길이가 N일 때, 끝 자리가 0 ~ 9를 구분하기 위해 선언
        int[][] dp = new int[N+1][11];

        long count = 0;

        // 길이가 1일 경우
        for(int i=1; i<=9; i++){
            dp[1][i] = 1;
        }


        for(int i=2; i<N+1; i++){
            // 끝 자리에 0이 올 수 있다. 이때 0이 오게 되면 계단 수를 만들기 위해 1 밖에 올 수가 없다.
            dp[i][0] = dp[i-1][1];

            for(int j=1; j<=9; j++){
                // 계단 수를 만들기 위해 (끝 자리 -1 + 끝 자리 +1)하면 된다.  
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        for(int i=0; i<=9; i++)
            count += dp[N][i];

        bw.write(count%1000000000 +"");

        bw.close();
        br.close();
    }


}

