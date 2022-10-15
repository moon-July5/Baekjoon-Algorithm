import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 2559번 - 수열 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 10 - 15
*    메모리 : 24604 KB
*    시간 : 1120 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜의 수
        int K = Integer.parseInt(st.nextToken()); // 합을 구하기 위한 연속적인 날짜의 수

        int[] arr = new int[N];

        // 매일 측정한 온도를 나타내는 정수 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 연속적인 K일의 온도의 합이 최대가 되는 값
        int answer = Integer.MIN_VALUE;

        for(int i=0; i<=N-K; i++){
            int sum = 0;
            // 연속적인 K일의 온도의 합을 누적해서 덧셈 
            for(int j=i; j<i+K; j++){
                sum += arr[j];
            }
            // 최댓값 갱신
            answer = Math.max(answer, sum);
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



