import java.io.*;
import java.util.Stack;

/*   Baekjoon 1874번 - 스택 수열 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 16
*    메모리 : 28624 KB
*    시간 :   384 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int number = 1; // 초기 값 1을 줘서 1 ~ n 까지의 정수를 표현

        for(int i=0; i<n; i++){
            int t = Integer.parseInt(br.readLine());

            // 주어진 정수 t까지 스택에 push하면서 "+" 출력
            while(number <= t){
                stack.push(number++);
                sb.append("+").append("\n");
            }

            // 스택 맨 위의 정수와 입력 값 t와 비교하여 같은지 확인
            // 같지 않다면 스택 수열이 될 수 없기 때문에 "NO" 출력 후 시스템 종료
            if(stack.peek() != t){
                System.out.println("NO");
                System.exit(0);
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
