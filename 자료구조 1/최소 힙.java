import java.io.*;
import java.util.*;

/*   Baekjoon 1927번 - 최소 힙 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 02
*    메모리 : 27408 KB
*    시간 : 388 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        PriorityQueue<Long> pq = new PriorityQueue<>(); // 우선순위 큐

        for(int i=0; i<N; i++){
            long x = Long.parseLong(br.readLine());

            if(x==0){ // 값을 출력하고 제거
                if(!pq.isEmpty()) bw.write(pq.poll()+"\n");
                else bw.write(0+"\n"); // 우선순위 큐에 값이 저장되어 있지 않다면
            } else {
                pq.add(x); // 값 저장장
            }   
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



