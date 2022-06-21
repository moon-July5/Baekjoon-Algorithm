import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11053번 - 가장 긴 증가하는 부분 수열 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 21
*    메모리 : 14984 KB
*    시간 : 152 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 수열의 크기

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[0] = 1;

        for(int i=1; i<N; i++){
            dp[i] = 1; // 초기값으로 1을 저장
            
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i] && dp[i]<=dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;

        for(int i=0; i<dp.length; i++) {
            if(max < dp[i])
                max = dp[i];
        }

        bw.write(max+"");

        bw.close();
        br.close();
    }


}

