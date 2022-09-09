import java.io.*;


/*   Baekjoon 2670번 - 연속부분최대곱 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 09
*    메모리 : 18532 KB
*    시간 : 188 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 실수 개수

        double[] arr = new double[N];
        double[] dp = new double[N];

        // N개의 실수 입력
        for(int i=0; i<N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = arr[0]; // 초기값
        double answer = 0.0; // 최댓값

        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]*arr[i], arr[i]); // i번째 연속 부분 중 최댓값 저장
            answer = Math.max(answer, dp[i]); // 최댓값 갱신
        }

        // 소수점 이하 넷째자리에서 반올림하여 소수점 이하 셋째 자리까지 출력
        bw.write(String.format("%.3f", answer));
        bw.flush();

        bw.close();
        br.close();
    }
}



