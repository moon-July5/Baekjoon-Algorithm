import java.io.*;
import java.util.*;

/*   Baekjoon 6198번 - 옥상 정원 꾸미기 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 09 - 06
*    메모리 : 23996 KB
*    시간 : 312 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 빌딩의 개수

        int[] arr = new int[N];

        // 빌딩들의 높이 입력
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        long answer = 0;

        for(int i=0; i<N; i++){
            // 스택이 비어있지 않고 스택에 있는 빌딩의 높이보다 크다면(현재 위치에서 다른 빌딩들을 볼 수 없다는 의미)
            while(!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();

            stack.push(arr[i]); // 빌딩의 높이 저장
            answer += stack.size() - 1;
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }
}



