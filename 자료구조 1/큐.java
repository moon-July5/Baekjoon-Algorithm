import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 10845번 - 큐 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 17
*    메모리 : 17960 KB
*    시간 : 232 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    // 명령어의 수

        Queue<Integer> queue = new LinkedList<>();
        int value = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();    // 명령어

            if(command.equals("push")){ // 큐에 삽입
                value = Integer.parseInt(st.nextToken());
                queue.add(value);
            } else if(command.equals("pop")){   // 큐에 가장 앞에 있는 정수 출력 후 삭제
                if(!queue.isEmpty()){
                    bw.write(queue.poll()+"\n");
                } else {    // 비어있다면 -1 출력
                    bw.write("-1\n");
                }
            } else if(command.equals("size")){  // 큐에 있는 정수 개수 출력
                bw.write(queue.size()+"\n");
            } else if(command.equals("empty")){ // 큐가 비어있는지 확인
                if(!queue.isEmpty()){
                    bw.write("0\n");
                } else {
                    bw.write("1\n");
                }
            } else if(command.equals("front")){ // 큐에 가장 앞에 있는 정수 출력
                if(!queue.isEmpty()){
                    bw.write(queue.peek()+"\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(command.equals("back")){  // 큐에서 가장 뒤에 있는 정수 출력
                if(!queue.isEmpty()){
                    bw.write(value+"\n");
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
