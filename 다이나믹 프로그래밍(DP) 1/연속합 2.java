import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 13398번 - 연속합 2 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 24
*    메모리 : 26392 KB
*    시간 : 284 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        // [N][0] : 수를 제거하지 않은 최댓값
        // [N][1] : 수를 제거한 최댓값
        int[][] dp = new int[N][2];

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];

        // 초기 값
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];

        for(int i=1; i<N; i++){
            // 수를 제거하지 않은 경우
            // (이전까지 합친 수 + 현재 수) 또는 (현재 수) 중에서 큰 값을 선택
            dp[i][0] = Math.max(dp[i-1][0]+arr[i], arr[i]);
            // 현재 수를 제거한 값의 경우 지금까지 수를 제거하지 않은 최댓값에서 가져온다.
            // 제거하지 않은 경우는 현재 수와 dp[i-1][1]을 더하고 그 중 최댓값을 선택
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

