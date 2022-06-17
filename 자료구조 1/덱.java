import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*   Baekjoon 10866번 - 덱 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 17
*    메모리 : 20088 KB
*    시간 : 256 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    // 명령어 수

        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();    // 명령어

            if(command.equals("push_front")){   // 덱의 가장 맨 앞에 정수 삽입
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if(command.equals("push_back")){ // 덱의 가장 맨 뒤에 정수 삽입
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if(command.equals("pop_front")){ // 덱의 가장 맨 앞에 정수 삭제
                if(!deque.isEmpty()){
                    bw.write(deque.pollFirst()+"\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(command.equals("pop_back")){  // 덱의 가장 맨 뒤에 정수 삭제
                if(!deque.isEmpty()){
                    bw.write(deque.pollLast()+"\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(command.equals("size")){  // 덱에 들어있는 정수 개수
                bw.write(deque.size()+"\n");
            } else if(command.equals("empty")){ // 덱이 비어있는지 확인
                if(!deque.isEmpty()){
                    bw.write("0\n");
                } else {
                    bw.write("1\n");
                }
            } else if(command.equals("front")){ // 덱의 가장 맨 앞 정수 출력
                if(!deque.isEmpty()){
                    bw.write(deque.peekFirst()+"\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(command.equals("back")){  // 덱의 가장 맨 뒤 정수 출력
                if(!deque.isEmpty()){
                    bw.write(deque.peekLast()+"\n");
                } else {
                    bw.write("-1\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
