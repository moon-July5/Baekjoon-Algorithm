import java.io.*;
import java.util.*;

/*   Baekjoon 2493번 - 탑 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 09 - 05
*    메모리 : 93988 KB
*    시간 : 908 ms
 */
class Node { // 탑의 정보를 나타내는 클래스
    int height, idx; // 탑의 높이와 번호

    public Node(int height, int idx){
        this.height = height;
        this.idx = idx;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 탑의 수

        Stack<Node> stack = new Stack<>();

        // 탑들의 높이 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int height = Integer.parseInt(st.nextToken()); // 탑의 높이 입력

            if(stack.isEmpty()){ // 스택이 비어있다면
                bw.write(0+" "); // 0 출력
                stack.push(new Node(height, i)); // 스택에 탑의 높이와 번호 저장
            } else { // 스택이 비어있지 않다면
                while (true){
                    if(stack.isEmpty()){
                        bw.write(0+" ");
                        stack.push(new Node(height, i));
                        break;
                    }

                    if(stack.peek().height > height){ // 스택에 저장된 탑의 높이가 현재 탑의 높이보다 높다면
                        bw.write(stack.peek().idx +" "); // 스택에 저장된 탑의 번호 출력
                        stack.push(new Node(height, i)); // 현재 탑의 정보를 스택에 저장
                        break;
                    } else { // 스택에 저장된 탑의 높이가 낮다면
                        stack.pop(); // 삭제
                    }
                }
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



