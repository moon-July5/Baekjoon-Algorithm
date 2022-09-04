import java.io.*;
import java.util.*;

/*   Baekjoon 11286번 - 절댓값 힙 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 04
*    메모리 : 26548 KB
*    시간 : 360 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        // 우선순위 큐를 이용하며, 절댓값에 따라 정렬한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) return 1;
                else if(Math.abs(o1)==Math.abs(o2)) return o1-o2;
                else return -1;
            }
        });

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());

            // 0이 아니면 우선순위 큐에 저장
            if(x!=0) {
                pq.add(x);
            }
            else { // 0일 경우에, 우선순위 큐가 비어있냐, 비어있지 않냐에 따라 연산한다.
                if(!pq.isEmpty()) bw.write(pq.poll()+"\n"); // 비어있지 않다면 값 출력 후 삭제
                else bw.write(0+"\n"); // 비어있으면 0 출력
            }
        }

        bw.close();
        br.close();
    }
}



