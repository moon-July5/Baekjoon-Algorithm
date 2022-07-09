import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*   Baekjoon 2529번 - 부등호 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 07 - 09
*    메모리 : 22804 KB
*    시간 : 268 ms
 */

public class Main {
    private static int K; // 부등호 문자의 개수
    private static char[] arr;
    private static boolean[] visited; // 방문 표시
    private static ArrayList<String> list = new ArrayList<>(); // 정수들을 저장할 list
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        arr = new char[K];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++)
            arr[i] = st.nextToken().charAt(0);

        dfs(0, "");
        Collections.sort(list); // 오름차순으로 정렬

        bw.write(list.get(list.size()-1)+"\n"); // 최대 정수 출력
        bw.write(list.get(0)+""); // 최소 정수 출력
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int depth, String num){
        // 부등호 앞 뒤로 넣을 숫자를 모두 선택했다면
        if(depth == K+1){
            // 정수를 list 에 저장
            list.add(num);
            return;
        }

        for(int i=0; i<10; i++){
            // 방문하지 않은 숫자라면
            if(!visited[i]){
                // 메서드 첫 호출이거나 부등호로 값을 비교하여 true 라면
                if(depth==0 || check(Character.getNumericValue(num.charAt(depth-1)), i, arr[depth-1])) {
                    visited[i] = true;
                    dfs(depth+1, num+i);
                    visited[i] = false;
                }
            }
        }
    }

    // 두 수와 입력받은 부등호로 값을 비교하여 판별
    public static boolean check(int a, int b, char c){
        if(c == '>'){
            if(a < b) return false;
        } else if(c == '<'){
            if(a > b) return false;
        }

        return true;
    }
}

