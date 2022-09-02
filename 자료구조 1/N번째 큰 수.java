import java.io.*;
import java.util.*;

/*   Baekjoon 2075번 - N번째 큰 수 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 02
*    메모리 : 272932 KB
*    시간 : 864 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 우선순위 큐 (내림차순), N번쨰 큰 수를 찾기 위해

        // N * N 크기의 정수 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        // N번째 큰 수를 출력하기 전에 N-1번째까지의 큰 수를 삭제한다.
        for(int i=0; i<N-1; i++)
            pq.poll();

        // N번째 큰 수 출력
        bw.write(pq.poll()+"");

        bw.close();
        br.close();
    }
}



