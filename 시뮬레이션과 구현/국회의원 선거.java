import java.io.*;
import java.util.*;

/*   Baekjoon 1417번 - 국회의원 선거 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 07 - 24
*    메모리 : 14416 KB
*    시간 : 144 ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 후보의 수
        int first = Integer.parseInt(br.readLine()); // 다솜이의 투표 수

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 내림차순 정렬

        for(int i=0; i<N-1; i++)
            pq.add(Integer.parseInt(br.readLine())); // 각 후보들의 투표 수

        int count = 0;

        // 우선순위 큐가 비어있지 않고 각 후보들의 투표 수가 다솜이의 투표 수보다 크다면
        while (!pq.isEmpty() && first++ <= pq.peek()){
            pq.add(pq.poll()-1); // 다솜이를 제외하고 가장 투표 수가 많은 후보의 투표 수를 하나씩 제거한다.
            count++; // 제거할 때마다 다솜이의 투표 수는 하나 씩 늘어난다.
        }

        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

