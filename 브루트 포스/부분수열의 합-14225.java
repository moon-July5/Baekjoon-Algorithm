import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 14225번 - 부분수열의 합 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 15
*    메모리 : 16404 KB
*    시간 : 148 ms
 */

public class Main {
    private static int N; // 수열 S의 크기
    private static int[] arr; // 수열 S
    private static boolean[] visited; // 방문 표시
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[20 * 100000 + 1];

        // 수열 S 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹 탐색
        solve(0, 0);

        int answer = 1;

        // 모든 부분수열의 합을 탐색한다. 
        // 인덱스를 증가시켜가며 false로 표시된 첫 값을 반환하도록 한다.  
        while (visited[answer]){
            answer++;
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
    
    // 부분수열의 합을 백트래킹을 통해 탐색
    public static void solve(int depth, int sum){
        if(depth == N){ 
            visited[sum] = true; // 부분수열의 합 인덱스에 true 표시
            return;
        }

        solve(depth+1, sum+arr[depth]);
        solve(depth+1, sum);
    }
}



