import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*   Baekjoon 13417번 - 카드 문자열 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 08 - 20
*    메모리 : 38904 KB
*    시간 : 368 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine()); // 카드의 개수

            char[] arr = new char[N];
            Deque<Character> deque = new LinkedList<>(); // 카드를 정렬할 공간

            // 카드의 문자 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                arr[i] = st.nextToken().charAt(0);

            // 가장 왼쪽에 있는 카드를 저장
            deque.add(arr[0]);

            for(int i=1; i<N; i++){
                // deque에서 사전 순으로 가장 빠른 문자보다 더 빠르다면 가장 맨 앞에 삽입 
                if(deque.getFirst().compareTo(arr[i]) > -1)
                    deque.addFirst(arr[i]);
                else // 그게 아니면 가장 맨 뒤에 삽입
                    deque.addLast(arr[i]);
            }

            // 사전 순으로 가장 빠른 문자를 출력
            while (!deque.isEmpty())
                bw.write(deque.pop()+"");
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}


