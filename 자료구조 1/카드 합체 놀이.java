import java.io.*;
import java.util.*;

/*   Baekjoon 15903번 - 카드 합체 놀이 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 04
*    메모리 : 15320 KB
*    시간 : 176 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 카드의 개수
        int M = Integer.parseInt(st.nextToken()); // 카드 합체 횟수

        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 카드의 상태 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            pq.add(Long.parseLong(st.nextToken()));

        for(int i=0; i<M; i++){
            long sum = pq.poll() + pq.poll(); // 가장 작은 수의 카드 2개를 합침

            // 가장 작은 수의 카드 2개를 합친 값을 우선순위 큐에 저장
            pq.add(sum); 
            pq.add(sum);
        }

        long answer = 0;

        // 카드의 상태를 모두 더한다.
        while (!pq.isEmpty()){
            answer += pq.poll();
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }
}



