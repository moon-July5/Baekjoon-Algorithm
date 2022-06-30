import java.io.*;
import java.util.*;

/*   Baekjoon 1890번 - 점프 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 30
*    메모리 : 14420 KB
*    시간 : 132 ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 게임판의 크기

        int[][] arr = new int[N][N];

        // 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 경로의 개수가 2^63 - 1보다 작거나 같기 때문에 long 형으로 선언
        long[][] dp = new long[N][N];
        // 경로의 개수를 1부터 시작
        dp[0][0] = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int next = arr[i][j];

                // 도착
                if(next == 0) break;
                // 오른쪽으로 이동
                if(next+j < N) dp[i][next+j] += dp[i][j];
                // 아래로 이동
                if(next+i < N) dp[next+i][j] += dp[i][j];
            }
        }

        bw.write(dp[N-1][N-1]+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

