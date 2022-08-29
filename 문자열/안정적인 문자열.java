import java.io.*;
import java.util.Stack;

/*   Baekjoon 4889번 - 안정적인 문자열 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 29
*    메모리 : 16300 KB
*    시간 : 192 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        int idx = 1;

        while(!(str = br.readLine()).contains("-")){
            Stack<Character> stack = new Stack<>();
            int answer = 0;

            for(int i=0; i<str.length(); i++){
                // 여는 괄호일 경우 스택에 저장
                if(str.charAt(i) == '{') stack.push(str.charAt(i));
                else { // 닫는 괄호일 경우
                    if(stack.isEmpty()) { // 스택이 비어있다면
                        stack.push('{');
                        answer++;
                    } else stack.pop(); // 스택이 비어있지 않다면
                }
            }

            // 마지막으로 스택이 비어있지 않다면 (스택 사이즈 / 2)를 추가적으로 계산
            if(!stack.isEmpty()) answer += stack.size()/2;

            bw.write((idx++)+". "+answer+"\n");

        }
        bw.flush();

        bw.close();
        br.close();
    }

}


