import java.io.*;

/*   Baekjoon 11057번 - 오르막 수 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 23
*    메모리 : 14312 KB
*    시간 : 128 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수의 길이

        // 수가 N길이 일 때, 맨 뒷 자리가 0~9 구분
        int[][] dp = new int[N+1][10];

        // 수의 길이가 1일 때
        for(int i=0; i<10; i++)
            dp[1][i] = 1;

        /*
            이 문제에서 수의 길이가 2 일 때 규칙을 찾아보자면
            맨 뒷자리가 0일 때, 00으로 1개, 1일 때, 01 11 2개, 2일 때 02 12 22 3개이며,
            9일 경우 10개가 될 것이다. 그래서 수의 길이가 2일 때, 1+2+3+4+5+6+7+8+9 = 55가지가 된다.

            수의 길이가 3 일 경우, 맨 뒷자리가 9일 때 55개, 8일 때 45개, 7일 때 36개로 규칙을 찾을 수 있다.

            즉, 수의 길이가 i일 때, i-1의 맨 뒷자리가 0 ~ 9까지 같거나 작은 수의 모든 경우의 수를 다 더하는 것이다.
         */
        for(int i=2; i<N+1; i++){ // 수의 길이
            for(int j=0; j<10; j++){ // 맨 뒷 자리 0 ~ 9
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        long count = 0;

        for(int i=0; i<10; i++) {
            count += dp[N][i];
        }

        bw.write(count%10007+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

