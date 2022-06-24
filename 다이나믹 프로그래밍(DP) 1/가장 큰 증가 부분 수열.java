import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11055번 - 가장 큰 증가 부분 수열 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 24
*    메모리 : 14876 KB
*    시간 : 152 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수열의 크기

        int[] arr = new int[N];
        int[] dp = new int[N];

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            // 초기값
            dp[i] = arr[i];

            // i 번째 수 전까지 확인
            for(int j=0; j<i; j++){
                // 지금 현재 수(i 번째 수)가 크고 (현재 수 이전에 나왔던 수+현재 수)가 크다면  
                if(arr[j]<arr[i] && dp[i]<dp[j]+arr[i]){
                    // dp 배열을 갱신
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int max = 0;

        // 위에 for 문을 거쳐서 갱신된 dp 배열에서 가장 큰 수를 탐색
        for(int i=0; i<N; i++){
            if(max<dp[i]) max = dp[i];
        }
        
        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

