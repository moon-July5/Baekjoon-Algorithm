import java.io.*;
import java.util.Arrays;

/*   Baekjoon 12852번 - 1로 만들기 2 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 14
*    메모리 : 23744 KB
*    시간 : 180 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];    // 연산 최소 횟수 저장
        int[] path = new int[N+1];  // 경로 저장

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0; // 초기값

        for(int i=2; i<=N; i++){
            // 3으로 나누어 떨어지면
            if(i%3 == 0) {
                if(dp[i/3]+1 < dp[i]) {
                    dp[i] = dp[i/3] + 1; // 연산 횟수 추가
                    path[i] = i/3; // 경로 저장
                }
            }
            // 2로 나누어 떨어지면
            if(i%2 == 0){
                if(dp[i/2]+1 < dp[i]){
                    dp[i] = dp[i/2] + 1; // 연산 횟수 추가
                    path[i] = i/2; // 경로 저장
                }
            }
            // 1을 빼는 경우
            if(dp[i-1]+1 < dp[i]){
                dp[i] = dp[i-1] + 1; // 연산 횟수 추가
                path[i] = i-1; // 경로 쩌장
            }
        }
        // 연산 횟수 출력
        bw.write(dp[N]+"\n");

        // 경로 출력
        while(N > 0){
            bw.write(N+" ");
            N = path[N];
        }
        bw.flush();

        bw.close();
        br.close();
    }
}

