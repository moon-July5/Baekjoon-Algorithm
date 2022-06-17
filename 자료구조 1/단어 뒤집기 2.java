import java.io.*;
import java.util.Stack;


/*   Baekjoon 17413번 - 단어 뒤집기2 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 17
*    메모리 : 22392 KB
*    시간 : 276 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        boolean flag = false;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='<'){   // 여는 괄호일 경우
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                flag = true;
            } else if(s.charAt(i)=='>'){    // 닫는 괄호일 경우
                sb.append(s.charAt(i));
                flag = false;
                continue;
            }

            // flag가 true일 경우, 닫는 괄호가 나오기 전까지 문자를 저장
            if(flag){
                sb.append(s.charAt(i));
            } else if(!flag){   // flag가 false일 경우, 괄호 외에 문자 처리
                if(s.charAt(i)==' '){   // 문자가 공백일 경우
                    while(!stack.isEmpty()){
                        sb.append(stack.pop()); // 스택에 들어있는 문자를 삭제 후 StringBuilder에 저장
                    }
                    sb.append(' '); // 그 후 공백 추가
                    continue;
                } else { // 공백이 아닐 경우, 그냥 문자 추가
                    stack.push(s.charAt(i));
                }
            }

            // 마지막 문자일 때
            if(i == s.length()-1){
                while(!stack.isEmpty()){ // 스택이 비어질 때까지 문자 추가
                    sb.append(stack.pop());
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
