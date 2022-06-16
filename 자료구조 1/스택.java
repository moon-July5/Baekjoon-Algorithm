import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*   Baekjoon 10828번 - 스택 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 16
*    메모리 - 18332KB
*    시간 - 228ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    // 명령의 수
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();    // 명령어

            if(command.equals("push")) // push
                stack.push(Integer.parseInt(st.nextToken()));
            else if(command.equals("pop")){ // pop
                if(stack.isEmpty()){    // 스택 가장 위에 있는 정수가 비어있는 경우
                    bw.write("-1\n");
                } else {
                    bw.write(stack.pop()+"\n");
                }
            }
            else if(command.equals("size")){    // size
                bw.write(stack.size()+"\n");
            }
            else if(command.equals("empty")){   // empty
                if(stack.isEmpty()){    // 스택 가장 위에 있는 정수가 비어있는 경우
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
            else if(command.equals("top")){ // top
                if(stack.isEmpty()){    // 스택 가장 위에 있는 정수가 비어있는 경우
                    bw.write("-1\n");
                } else {
                    bw.write(stack.peek()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
