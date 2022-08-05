import java.io.*;
import java.util.*;

/*   Baekjoon 19638번 - 센티와 마법의 뿅망치 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 05
*    메모리 : 28864 KB
*    시간 : 416 ms 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 거인 나라의 인구 수
        int H = Integer.parseInt(st.nextToken()); // 센티의 키
        int T = Integer.parseInt(st.nextToken()); // 마법의 뿅망치 횟수 제한

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐를 내림차순으로 정렬

        for(int i=0; i<N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int t = 0;

        while(t++ < T){
            int value = pq.poll(); // 거인들 중에서 가장 큰 키를 불러옴

            if(value < H){ // 거인들 중에서 가장 큰 키가 센티보다 작을 경우
                pq.add(value); // 우선순위 큐에 삽입
                break;
            } else { // 센티 키가 거인들보다 작으면
                if(value/2 == 0 ){ // 만약 마법의 뿅먕치로 거인을 쳤을 때 0이 됐을 때 최소한의 키는 1이다
                    pq.add(1);
                    break;
                } else { // 0이 아니면 가장 큰 키에서 /2를 한 값을 우선순위 큐에 저장
                    pq.add(value/2);
                }
            }
        }

        if(pq.peek() < H){ // 거인들 중에서 가장 큰 키가 센티보다 작을 경우
            bw.write("YES\n");
            bw.write(t-1+""); // 마법의 뿅망치를 사용한 횟수
        } else { // 센티키가 거인들보다 작을 경우
            bw.write("NO\n");
            bw.write(pq.poll()+""); // 거인들 중에서 가장 큰 키
        }
        bw.flush();

        bw.close();
        br.close();
    }

}

