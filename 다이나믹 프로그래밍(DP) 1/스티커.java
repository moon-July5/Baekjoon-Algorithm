import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 9465번 - 스티커 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 23
*    메모리 : 112708 KB
*    시간 : 836 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());    // 스티커 2n 개

            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            // 입력
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<n+1; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기값
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            /*
                dp[0][i] = 첫 번째 행에서 i 번째 수를 선택했을 때, i 번째 수 주변은 선택할 수 없다.
                그래서 i 번쨰 수 왼쪽 하단에 있는 수 또는 왼쪽 하단의 왼쪽에 있는 수 중에서 높은 수를 선택한다.
                
                dp[1][i] = 위의 설명과 마찬가지이며, i 번째 수 주변은 선택할 수 없기 때문에
                오른쪽 상단 수 또는 오른쪽 상단의 오른쪽에 있는 수 중에서 높은 수를 선택하여 더한다. 
             */
            for(int i=2; i<n+1; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
            }

            bw.write(Math.max(dp[0][n], dp[1][n])+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }


}



