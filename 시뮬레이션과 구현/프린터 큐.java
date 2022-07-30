import java.io.*;
import java.util.*;

/*   Baekjoon 1966번 - 프린터 큐 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 30
*    메모리 : 15828 KB
*    시간 : 184 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째로 놓여 있는지 나타낸 정수

            LinkedList<int[]> queue = new LinkedList<>();

            // N개의 문서의 중요도
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
               queue.add(new int[] {Integer.parseInt(st.nextToken()), i });
            }

            int count = 0;

            while(!queue.isEmpty()){

                int[] front = queue.poll(); // 가장 첫 원소
                boolean isMax = true; // 가장 첫 원소가 큰 수 인지 판별

                for(int i=0; i<queue.size(); i++){
                    if(front[0] < queue.get(i)[0]) { // 첫 원소보다 i번째 원소의 중요도가 더 클 경우
                        // 뽑은 원소와 i 이전의 원소들을 맨 뒤에 보낸다.
                        queue.add(front);

                        for(int j=0; j<i; j++){
                            queue.add(queue.poll());
                        }

                        isMax = false; // front 원소가 가장 큰 원소가 아니였으므로 false로 저장하고 빠져나간다.
                        break;
                    }
                }

                if(!isMax) continue; // 다음 반복문으로 이동

                count++; // front 원소가 가장 큰 원소였으므로 출력해야 한다.

                if(front[1]==M) break; // 찾고자 하는 문서라면 종료
            }

            bw.write(count+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

}

