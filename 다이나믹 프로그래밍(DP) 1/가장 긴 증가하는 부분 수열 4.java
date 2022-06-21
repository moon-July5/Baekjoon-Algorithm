import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*   Baekjoon 14002번 - 가장 긴 증가하는 부분 수열 4 (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 21
*    메모리 : 16936 KB
*    시간 : 172 ms
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
        int max = 1;

        for(int i=1; i<N; i++){
            dp[i] = 1;

            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    // 증가하는 부분 수열의 크기 갱신
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    // 가장 긴 부분 수열의 길이 갱신
                    max = Math.max(dp[i], max);
                }
            }
        }
        bw.write(max+"\n");

        // 스택을 통해 부분 수열을 담는다.
        Stack<Integer> stack = new Stack<>();
        for(int i=N-1; i>=0; i--){
            // 가장 긴 부분 수열의 길이를 통해 역추적으로 수열을 탐색
            if(dp[i]==max){
                stack.push(arr[i]);
                max--;
            }
        }

        while (!stack.isEmpty()){
            bw.write(stack.pop()+" ");
        }
        
        bw.flush();

        bw.close();
        br.close();
    }


}

