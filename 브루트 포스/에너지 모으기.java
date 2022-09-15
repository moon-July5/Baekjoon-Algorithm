import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*   Baekjoon 16198번 - 에너지 모으기 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 15
*    메모리 : 18532 KB
*    시간 : 176 ms
 */

public class Main {
    private static int N; // 에너지 구슬의 개수
    private static ArrayList<Integer> list; // 에너지 구슬의 무게 저장
    private static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        // 에너지 구슬들의 무게 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            list.add(Integer.parseInt(st.nextToken()));

        // 모을 수 있는 에너지의 최댓값을 위해 탐색
        solve(0);

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void solve(int sum){
        if(list.size() <= 2){ // 첫 번째 구슬과 마지막 구슬만 남았다면
            answer = Math.max(answer, sum); // 최댓값 갱신
            return;
        }

        for(int i=1; i<list.size()-1; i++){
            int temp = list.get(i); // 값 임시 저장
            int value = list.get(i-1) * list.get(i+1); // 선택한 구슬의 양 옆의 무게를 곱한다.
            list.remove(i); // 선택한 구슬 삭제

            solve(sum + value);

            list.add(i, temp); // 선택한 구슬 다시 삽입
        }
    }
}



