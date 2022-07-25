import java.io.*;
import java.util.*;

/*   Baekjoon 1551번 - 수열의 변화 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 25
*    메모리 : 14316 KB
*    시간 : 132 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열의 크기
        int K = Integer.parseInt(st.nextToken()); // 연산 횟수

        Queue<Integer> queue = new LinkedList<>(); // 수열을 저장할 Queue 선언

        st = new StringTokenizer(br.readLine(), ",");
        for(int i=0; i<N; i++)
            queue.add(Integer.parseInt(st.nextToken()));

        for(int k=0; k<K; k++){ // 연산 횟수 만큼
           for(int i=0; i<(N-1)-k; i++){ // 연산 횟수가 증가할 때마다 수열의 크기는 그만큼 줄어든다.
               int cur = queue.poll(); // 가장 맨 앞에 있는 수를 꺼낸다.

               queue.add(queue.peek() - cur); // 방금 꺼낸 수의 다음 수에서 변수 cur에 저장된 수를 빼주면서 queue에 삽입
           }
           queue.poll(); // 연산이 끝나면 수열 가장 끝에 있던 수가 맨 앞에 아직 존재하기 때문에 삭제
        }

        // 연산이 끝난 수열을 출력
        while(!queue.isEmpty()){
            bw.write(queue.poll()+"");

            if(queue.size()!=0)
                bw.write(",");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}

