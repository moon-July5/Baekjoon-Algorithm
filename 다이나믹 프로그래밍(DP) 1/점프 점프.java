import java.io.*;
import java.util.*;


/*   Baekjoon 11060번 - 점프 점프 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 09
*    메모리 : 14476 KB
*    시간 : 148 ms
 */

public class Main {
    private static int N; // 미로의 세로 크기
    private static int[] arr;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;

        for(int i=1; i<=N; i++){
            if(dp[i] != Integer.MAX_VALUE){ 
                int jump = arr[i];

                for(int j=1; j<=jump; j++){
                    if(i + j > N) break;

                    dp[i + j] = Math.min(dp[i]+1, dp[i + j]);
                }
            }
        }

        if(dp[N] == Integer.MAX_VALUE)
            bw.write(-1+"");
        else
            bw.write(dp[N]+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

