import java.io.*;
import java.util.*;

/*   Baekjoon 2800번 - 괄호 제거 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 09 - 06
*    메모리 : 20568 KB
*    시간 : 224 ms
 */

public class Main {
    private static List<int[]> list; // 괄호 쌍 인덱스를 저장
    private static Set<String> answer; 
    private static boolean[] visited; // 괄호 방문 표시
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); // 음이 아닌 정수로 이루어진 수식 입력

        list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // 괄호의 쌍을 구한다.
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(') stack.push(i);
            else if(str.charAt(i) == ')') list.add(new int[] {stack.pop(), i});
        }

        answer = new TreeSet<>(); // 중복 제거, 사전 순 정렬을 위한 TreeSet
        visited = new boolean[str.length()];

        comb(0, str.toCharArray());

        answer.stream().forEach(System.out::println);

        bw.close();
        br.close();
    }

    public static void comb(int depth, char[] str){
        // 괄호 쌍 개수와 같다면
        if(depth == list.size()) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<str.length; i++){
                // 방문 표시 한 괄호 쌍을 제외한 문자를 저장
                if(!visited[i]) sb.append(str[i]);
                else flag = true;
            }

            if(flag) answer.add(sb.toString());

            return;
        }
        
        comb(depth+1, str);

        // 괄호 쌍 인덱스를 불러온다.
        int[] bracket = list.get(depth);

        // 괄호 쌍 방문 표시
        visited[bracket[0]] = true; 
        visited[bracket[1]] = true;

        // 재귀함수로 괄호 포함 여부에 따라 문자를 조합
        comb(depth+1, str);

        // 괄호 쌍 미방문 표시
        visited[bracket[0]] = false;
        visited[bracket[1]] = false;
    }
}



