import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 14501번 - 퇴사 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 08
*    메모리 : 14412 KB
*    시간 : 136 ms
 */

public class Main {
    private static int N;
    private static int[] time, money;
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        time = new int[N];
        money = new int[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken()); // 상담을 완료하는데 걸리는 기간
            money[i] = Integer.parseInt(st.nextToken()); // 받을 수 있는 금액
        }

        recursion(0, 0);

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void recursion(int depth, int p){
        if(depth >= N){
            max = Math.max(max, p);
            return;
        }

        // 상담 기간이 N 일 보다 짧을 경우
        if(depth + time[depth] <= N){
            // 걸리는 시간과 금액을 계산하여 재귀 호출
            recursion(depth+time[depth], p+money[depth]);
        } else {
            // 퇴사 날짜가 지났으면 여태까지 얻은 이익을 재귀 호출
            recursion(depth+time[depth], p);
        }

        // depth + 1 을 하여 이익을 더 얻을 수 있는 경우의 수를 탐색
        recursion(depth+1, p);
    }
}

