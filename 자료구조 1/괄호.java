import java.io.*;
import java.util.Stack;

/*   Baekjoon 9012번 - 괄호 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 16
*    메모리 :  14368 KB
*    시간 :   144 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수

        for(int i=0; i<T; i++){
            Stack<Character> stack = new Stack<>();     // 괄호를 넣어줄 공간
            boolean vps = true;     // 괄호 문자열이 올바르게 구성되어있는지 확인
            String s = br.readLine();

            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);

                if(c=='('){     // 여는 괄호 '('일 경우
                    stack.push(c);  // 스택에 저장
                } else if(c==')'){  // 닫는 괄호 ')'일 경우
                    if(!stack.isEmpty() && stack.peek()=='('){ // 스택이 비어있지 않고 스택 맨 위가 여는 괄호일 경우
                        stack.pop();    // 올바르게 괄호 쌍이 되기 때문에 여는 괄호 제거
                    } else {
                        vps = false;    // 만약 닫는 괄호일 경우, 올바르지 않기 때문에 False로 변환 후 break
                        break;
                    }
                }
            }
            // 여기서 NO, YES 판별
            // vps가 false거나 스택이 비어있지 않으면(괄호쌍이 모두 없어지지 않았다면) 
            if(!vps || !stack.isEmpty())
                bw.write("NO\n");
            else
                bw.write("YES\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
