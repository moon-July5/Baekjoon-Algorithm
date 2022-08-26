import java.io.*;
import java.util.Stack;

/*   Baekjoon 2257번 - 화학식량 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 26
*    메모리 : 14284 KB
*    시간 : 132 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        Stack<Integer> stack = new Stack<>();

        int val = 0; // 원자 질량을 저장할 변수
        stack.push(0);

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c=='('){ // 여는 괄호일 경우
                stack.push(0); // 0을 스택에 저장
            } else if(c==')'){ // 닫는 괄호일 경우
                val = stack.pop(); // 괄호 안에 있는 값을 모두 계산하기 위해 맨 위에 있는 값을 불러옴
                stack.push(stack.pop() + val);
            } else if(c>='2' && c<='9'){ // 숫자일 경우
               stack.push(stack.pop() + val * (c-'0'-1));
            } else {
                if(c=='H') val = 1; // 수소
                else if(c=='C') val = 12; // 탄소
                else if(c=='O') val = 16; // 산소

                stack.push(stack.pop() + val);
            }
        }

        bw.write(stack.pop()+"");

        bw.close();
        br.close();
    }
}


