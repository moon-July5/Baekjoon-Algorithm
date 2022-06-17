import java.io.*;
import java.util.Stack;


/*   Baekjoon 10799번 - 쇠막대기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 17
*    메모리 : 16396 KB
*    시간 : 184 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        int count = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') // 여는 괄호일 경우 스택에 저장
                stack.push('(');
            else if(s.charAt(i) == ')') {   // 닫는 괄호일 경우
                if(s.charAt(i-1) == '(') {  // 그 전 문자가 여는 괄호일 경우 레이저를 의미
                    stack.pop();
                    count += stack.size();  // 스택의 크기만큼 더함
                } else {    // 그 전 문자가 닫는 괄호일 경우 1을 더함
                    stack.pop();
                    count += 1;
                }
            }
        }
        bw.write(count + "");

        bw.close();
        br.close();
    }
}
