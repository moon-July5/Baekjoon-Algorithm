import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1535번 - 안녕 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 13
*    메모리 : 14332 KB
*    시간 : 132 ms
 */

public class Main {
    private static int N; // 사람의 수
    private static int[] health; // 각각의 사람한테 인사할 때, 잃는 체력
    private static int[] pleasure; // 각각의 사람한테 인사할 때, 얻는 기쁨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        health = new int[N+1];
        pleasure = new int[N+1];

        // 잃는 체력 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            health[i] = Integer.parseInt(st.nextToken());

        // 얻는 기쁨 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            pleasure[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[100];

        for(int i=0; i<N; i++){
            // 체력 100이 안넘어가는 선에서
            for(int j=99; j>=health[i]; j--){
                dp[j] = Math.max(dp[j-health[i]]+pleasure[i], dp[j]); // 체력에 따른 기쁨의 값 저장
            }
        }

        bw.write(dp[99]+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



