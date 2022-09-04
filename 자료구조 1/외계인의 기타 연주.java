import java.io.*;
import java.util.*;

/*   Baekjoon 2841번 - 외계인의 기타 연주 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 04
*    메모리 : 122352 KB
*    시간 : 724 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 멜로디에 포함되어 있는 음의 수
        int P = Integer.parseInt(st.nextToken()); // 한 줄에 있는 프렛의 수

        Stack<Integer>[] stack = new Stack[7]; // 기타 6줄

        for(int i=1; i<7; i++)
            stack[i] = new Stack<>();

        int answer = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken()); // 줄 번호
            int fret = Integer.parseInt(st.nextToken()); // 프렛 번호

            // 스택 각 줄의 프렛이 비어있지 않다면
            while(!stack[line].isEmpty()){
                // 스택에 들어있는 프렛의 값보다 입력받은 프렛의 값이 큰 경우 push
                if(stack[line].peek() < fret){
                    stack[line].push(fret);
                }
                // 스택에 들어있는 프렛의 값보다 입력받은 프렛의 값이 작은 경우 pop
                else if(stack[line].peek() > fret){
                    stack[line].pop();
                } else {
                    break;
                }

                answer += 1;
            }

            // 스택 각 줄의 플랫이 비어있다면
           if(stack[line].isEmpty()) {
               stack[line].push(fret);
               answer += 1;
           }
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }
}



