import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*   Baekjoon 1406번 - 에디터 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 17
*    메모리 : 137048 KB
*    시간 : 712 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();   // 문자열
        int M = Integer.parseInt(br.readLine());    // 명령어의 개수

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i=0; i<str.length(); i++)
            left.add(str.charAt(i));

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // 명령어

            if(command.equals("L")){    // 커서를 왼쪽으로 한 칸 옮김
                if(!left.isEmpty()){
                    right.add(left.pop()); // 오른쪽 스택에 임시로 옮긴다.
                }
            } else if(command.equals("D")){ // 커서를 오른쪽으로 한 칸 옮김
                if(!right.isEmpty()){
                    left.add(right.pop());  // 왼쪽 스택에 임시로 옮긴다.
                }
            } else if(command.equals("B")){ // 커서 왼쪽에 있는 문자를 삭제
                if(!left.isEmpty()){
                    left.pop(); // 왼쪽 스택의 맨 위에 문자를 삭제한다.
                }
            } else if(command.equals("P")){ // 커서 왼쪽에 문자 추가
                left.add(st.nextToken().charAt(0)); // 왼쪽 스택에 문자 추가가
           }
        }

        // 오른쪽 스택이 비어있지 않다면
        // 왼쪽 스택에 문자를 옮겨준다.
        while(!right.isEmpty()){
            left.add(right.pop());
        }

        // 스택 출력
        for(int i=0; i<left.size(); i++){
            bw.write(left.elementAt(i)+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

