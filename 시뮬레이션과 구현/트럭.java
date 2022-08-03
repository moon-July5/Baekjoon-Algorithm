import java.io.*;
import java.util.*;

/*   Baekjoon 13335번 - 트럭 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 03
*    메모리 : 15380 KB
*    시간 : 152 ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
        int W = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            queue.add(Integer.parseInt(st.nextToken()));

        // 다리 길이 W 만큼 0 저장
        for(int i=0; i<W; i++)
            bridge.add(0);

        int count = 0; // 다리를 건너는 최단 시간
        int w = 0; // 현재 다리 위의 총 무게

        while (!bridge.isEmpty()){
            w -= bridge.poll();

            if(!queue.isEmpty()){ // 건너야될 트럭이 존재한다면
                if(w + queue.peek() <= L){ // 현재 다리 위의 무게가 다리의 최대 하중보다 작아야 한다.
                    int newTruck = queue.poll(); // 건너야될 트럭을 이동
                    w += newTruck; // 총 무게에 포함
                    bridge.add(newTruck);
                } else { // 현재 다리 위의 무게가 크다면
                    bridge.add(0);
                }
            }

            count++;
        }

        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

