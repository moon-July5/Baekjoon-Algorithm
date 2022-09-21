import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11501번 - 주식 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 21
*    메모리 : 317268 KB
*    시간 : 1156 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스의 개수

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine()); // 날의 수

            int[] arr = new int[N];

            // 날 별 주가 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            long answer = 0; // 최대 이익 합
            int max = 0;

            // 마지막 날부터 탐색
            for(int i=N-1; i>=0; i--){
                if(arr[i] > max) // 주가가 높다면
                    max = arr[i]; // 갱신
                else // max의 주가보다 낮다면
                    answer += (max - arr[i]); // 주가를 팔아 이익을 챙긴다.
            }

            bw.write(answer+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



