import java.io.*;
import java.util.*;


/*   Baekjoon 4949번 - 균형잡힌 세상 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 08 - 17
*    메모리 : 19416 KB
*    시간 : 244 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        
        while(!(s = br.readLine()).equals(".")){
            Stack<Character> stack = new Stack<>(); // 괄호를 저장할 공간
            boolean flag = true; // 괄호 일치 여부

            // 문자열의 개수만큼 반복
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);

                // 여는 괄호일 경우
                if(ch=='(' || ch=='['){
                    // 스택에 저장
                    stack.push(ch);
                // 닫는 소괄호일 경우    
                } else if(ch==')'){
                    // 스택이 비어있지 않고 스택의 맨 위의 문자가 여는 괄호('(') 일 경우
                    if(!stack.isEmpty() && stack.peek()=='('){
                        // 스택의 맨 위 문자 삭제
                        stack.pop();
                    } else {
                        // 괄호 일치 여부를 false 로
                        flag = false;
                        break;
                    }
                // 위의 닫는 소괄호일 경우와 동일    
                } else if(ch==']'){
                    if(!stack.isEmpty() && stack.peek()=='['){
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            
            // 예외의 경우 처리
            if(!stack.empty() || !flag) bw.write("no\n");
            else bw.write("yes\n");
        }

        bw.close();
        br.close();
    }
}


