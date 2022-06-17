import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 1158번 - 요세푸스 문제 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 17
*    메모리 : 295908 KB
*    시간 : 580 ms 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N명의 사람
        int K = Integer.parseInt(st.nextToken()); // 제거할 K번째 사람

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        bw.write("<");

        while (queue.size() != 1){
            // K번 만큼 계속 삭제 후 삽입
            for(int i=0; i<K-1; i++){
                queue.add(queue.poll());
            }
            
            // 큐에서 가장 앞에 있는 정수를 삭제 후 출력
            // 위의 for문으로 인해 K번째가 가장 앞에 있기 때문에
            bw.write(queue.poll()+", ");
        }

        // 큐에 남은 마지막 정수를 출력
        bw.write(queue.poll()+">");

        bw.flush();
        bw.close();
        br.close();
    }
}
