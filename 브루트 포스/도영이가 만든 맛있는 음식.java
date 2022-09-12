import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 2961번 - 도영이가 만든 맛있는 음식 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 12
*    메모리 : 14404 KB
*    시간 : 440 ms
 */

public class Main {
    private static int N; // 재료의 개수
    private static int[][] arr;
    private static boolean[] visited; // 방문 표시
    private static int min = Integer.MAX_VALUE; // 신맛과 쓴맛의 차이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        visited = new boolean[N];

        // 재료의 신맛과 쓴맛 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 신맛
            int B = Integer.parseInt(st.nextToken()); // 쓴맛

            arr[i][0] = S;
            arr[i][1] = B;
        }

        // 백트래킹 호출
        for(int i=1; i<=N; i++)
            solve(0, i, 1, 0);

        bw.write(min + "");
        bw.flush();

        bw.close();
        br.close();
    }

    // 재료를 1개 사용할 때, 2개, 3개, ... 를 표현하는 변수 k
    // 신맛의 값 sour, 쓴맛의 값 bitter를 표현하는 변수
    public static void solve(int depth, int k, int sour, int bitter){
        if(depth == k){ // 재료를 k개를 골랐을 때, 신맛과 쓴맛 차이의 최솟값
            min = Math.min(min, Math.abs(sour - bitter));
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){ // 방문하지 않았다면
                visited[i] = true; // 방문 표시
                solve(depth+1, k, sour*arr[i][0], bitter+arr[i][1]); // 신맛은 곱하고 쓴맛은 더한다.
                visited[i] = false; // 미방문 표시
            }
        }
    }
}



