import java.io.*;
import java.util.Arrays;

/*   Baekjoon 12026번 - BOJ 거리 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 01
*    메모리 : 15648 KB
*    시간 : 144 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 보도블록의 개수

        char[] arr = new char[N];
        int[] dp = new int[N];

        // 입력
        String s = br.readLine();
        for(int i=0; i<N; i++){
            arr[i] = s.charAt(i);
        }

        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for(int i=0; i<N-1; i++){
            char now = arr[i]; // 현재 보도블록

            if(now=='B'){
                for(int j=i+1; j<N; j++){
                    char next = arr[j]; // 다음 보도블록
                    if(next=='O'){ // 다음 보도블록이 'O' 이면
                        // 현재까지 발견된 최솟값, i번째 까지의 최소비용 + i에서 j로 점프하는데 드는 비용
                        dp[j] = Math.min(dp[j], dp[i]+(j-i)*(j-i));
                    }
                }
            } else if(now=='O'){
                for(int j=i+1; j<N; j++){
                    char next = arr[j];
                    if(next=='J'){
                        dp[j] = Math.min(dp[j], dp[i]+(j-i)*(j-i));
                    }
                }
            } else {
                for(int j=i+1; j<N; j++){
                    char next = arr[j];
                    if(next=='B'){
                        dp[j] = Math.min(dp[j], dp[i]+(j-i)*(j-i));
                    }
                }
            }
        }
        if(dp[N-1]==987654321)
            bw.write("-1");
        else
            bw.write(dp[N-1]+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

