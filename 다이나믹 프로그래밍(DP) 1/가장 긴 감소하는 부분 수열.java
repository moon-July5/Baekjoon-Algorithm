import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11722번 - 가장 긴 감소하는 부분 수열 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 24
*    메모리 : 15180 KB
*    시간 : 148 ms
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
        
        // 초기값
        dp[0] = 1;

        for(int i=1; i<N; i++){
            // 길이가 1부터 시작
            dp[i]=1;
            
            // i번째 수 전까지 비교
            for(int j=0; j<i; j++){
                // 현재 수보다 비교하려는 수가 커야 하고 dp 배열을 통해 길이 계산 
                if(arr[i]<arr[j] && dp[i]<=dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;

        // 위의 for 문을 통해 갱신된 dp 배열 중에서 가장 길이가 긴 배열 탐색
        for(int i=0; i<N; i++){
            if(max<dp[i]){
                max = dp[i];
            }
        }

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

