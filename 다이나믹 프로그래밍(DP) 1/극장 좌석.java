import java.io.*;

/*   Baekjoon 2302번 - 극장 좌석 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 14
*    메모리 : 14268 KB
*    시간 : 124 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 극장 좌석의 개수
        int M = Integer.parseInt(br.readLine()); // 고정석의 개수

        int[] dp = new int[41]; // 고정석을 제외한 일반 좌석들의 경우의 수 저장

        dp[0] = 1; dp[1] = 1; dp[2] = 2;

        for(int i=3; i<=N; i++)
            dp[i] = dp[i-2] + dp[i-1];

        int count = 1;
        int beforeSeat = 0;

        // 고정석 입력
        // 고정석을 제외한 나머지 좌석의 경우의 수를 곱함
        for(int i=0; i<M; i++){
            int vip = Integer.parseInt(br.readLine());
            count *= dp[vip - beforeSeat - 1];
            beforeSeat = vip;
        }

        count *= dp[N - beforeSeat]; // 마지막 고정석 다음 좌석부터 마지막 좌석까지 경우의 수

        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }
}

