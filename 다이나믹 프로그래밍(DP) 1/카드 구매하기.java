import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11052번 - 카드 구매하기 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 21
*    메모리 : 14840 KB
*    시간 : 160 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 구매하려고 하는 카드의 개수

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 카드 1개가 들어있는 카드팩을 구매하게 된다면, 카드 i-1개를 구입한다.
        // 카드 2개가 들어있는 카드팩을 구매하게 된다면, 카드 i-2개를 구입한다.
        for(int i=1; i<N+1; i++){
            for(int j=1; j<i+1; j++){
                dp[i] = Math.max(dp[i], dp[i-j]+arr[j]);
            }
        }

        bw.write(dp[N]+"");

        bw.close();
        br.close();
    }


}

				