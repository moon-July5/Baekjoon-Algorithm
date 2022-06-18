import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


/*   Baekjoon 17299번 - 오등큰수 (Gold Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 18
*    메모리 : 149228 KB
*    시간 : 1080 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];
        int[] count = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            // 입력 받은 정수 인덱스를 count 한다.
            // 그래서 count 배열의 크기를 이 문제의 입력 범위만큼 만들었다.
            count[arr[i]]++;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            // 자기 오른쪽에 등장 횟수가 큰 수가 있는지 확인
            // 일단, 스택이 비어있지 않아야 한다.
            // 자기 오른쪽에 등장 횟수와 스택에 담긴 인덱스에 들어있는 값을 비교한다.
            while(!stack.isEmpty() && count[arr[i]]>count[arr[stack.peek()]]){

                // 답을 출력할 answer 배열에 스택에 들어있는 인덱스를 삭제하면서
                // 자기 오른쪽에 등장 횟수가 큰 수를 저장한다.
                answer[stack.pop()] = arr[i];
            }

            // 인덱스를 스택에 삽입
            stack.push(i);
        }

        // 스택이 비어있지 않다면, 즉, 현재 오른쪽에 등장 횟수가 큰 수가 없다는 의미
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        for(int n : answer)
            bw.write(n+" ");

        bw.close();
        br.close();
    }
}
/*
 혼자서 정말 풀어보고 싶었지만 도저히 어떻게 풀지 생각이 안나서 다른 분 것을 참고했습니다.
 처음에 입력받은 수를 count 하기위한 count 배열을 생각했지만 그 이후로 어떻게 비교해야 할까 고민했습니다.

 참고해보니 코드는 간단해 보이지만 이걸 코드로 구현하기까지 쉽지 않았을 것이라 생각합니다.
 이러한 생각을 가질 수 있도록 더 공부해야겠다고 느꼈습니다.
 */
