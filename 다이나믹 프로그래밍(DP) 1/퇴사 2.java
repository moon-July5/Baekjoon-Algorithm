import java.io.*;
import java.util.*;

/*   Baekjoon 15486번 - 퇴사 2 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 30
*    메모리 : 309988 KB
*    시간 : 732 ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 일하는 기간
        int[] T = new int[N+2]; // 걸리는 기간
        int[] P = new int[N+2]; // 수익

        for(int n=1; n<N+1; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[n] = Integer.parseInt(st.nextToken());
            P[n] = Integer.parseInt(st.nextToken());
        }

        int max = 0; // 최대 수익

        int[] dp = new int[N+2]; 

        for(int i=1; i<N+2; i++){
            if(max < dp[i]) max = dp[i];

            // 현재 일하고 있는 날 + 걸리는 기간
            int day = i + T[i];

            if(day < N+2){
                dp[day] = Math.max(dp[day], max+P[i]);
            }
        }

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

