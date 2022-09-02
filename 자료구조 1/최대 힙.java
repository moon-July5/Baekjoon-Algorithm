import java.io.*;
import java.util.*;

/*   Baekjoon 11279번 - 최대 힙 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 02
*    메모리 : 27180 KB
*    시간 : 376 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 우선순위 큐 (내림차순)

        for(int i=0; i<N; i++){
            long x = Long.parseLong(br.readLine());

            if(x==0){ // 값을 출력하고 제거
                if(!pq.isEmpty()) bw.write(pq.poll()+"\n");
                else bw.write(0+"\n"); // 우선순위 큐가 비어있으면 0 출력
            } else {
                pq.add(x); // 우선순위 큐에 값 저장
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



