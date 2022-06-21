import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 16194번 - 카드 구매하기 2 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 21
*    메모리 : 14656 KB
*    시간 : 156 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            // 최소비용을 구하기 위해 dp 배열을 1 ~ N 개까지의 카드 가격 초기화
            dp[i] = arr[i];
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j]+arr[j]);
            }
        }

        bw.write(dp[N]+"");

        bw.close();
        br.close();
    }


}

