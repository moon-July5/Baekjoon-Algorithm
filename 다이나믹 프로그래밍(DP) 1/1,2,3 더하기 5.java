import java.io.*;

/*   Baekjoon 15990번 - 1,2,3 더하기 5 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 21
*    메모리 : 21440 KB
*    시간 : 200 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        // dp배열을 2차원 배열로 선언
        // dp[n]의 연산 식이 1로 끝나는지, 2로 끝나는지, 3으로 끝나는지에 따라 구분
        long[][] dp = new long[100001][4];

        /*
           n이 3이라고 하면 문제에 나와있는대로 3으로 나타낼 수 있는 방법은 2+1, 1+2, 3이 있다.
           여기서 1로 끝나는 식이 2+1로 1개, 2로 끝나는 식이 1+2로 1개, 3으로 끝나는 식이 1개있다.

           그래서 아래와 같이 값을 초기화 해준다.
         */
        dp[1][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;


        /*
           각각 1, 2, 3으로 끝나는 연산의 개수를 계산한다.
           1로 끝나는 식은 그 전까지의 합이 i-1이 되어야 하고 
           식의 마지막은 1로 끝나야 하기 때문에 dp[i-1][1]은 포함하지 않는다.
        */
        for(int i=4; i<dp.length; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
        }

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            // 1, 2, 3으로 끝나는 식의 개수들을 모두 더한 값이 결과다.
            long result = (dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009;

            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}

