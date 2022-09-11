import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 18429번 - 근손실 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 11
*    메모리 : 14360 KB
*    시간 : 136 ms
 */

public class Main {
    private static int N, K; // 일 수, 중량 감소량
    private static int[] arr;
    private static boolean[] visited; // 방문 표시
    private static int answer = 0; // 정답 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        // 운동 키트의 중량 증가량 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 백트래킹을 통해서 모든 조합 탐색
        solve(0, 500);

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void solve(int depth, int sum){
        // 만약 (500 + 운동 키트 증가량 - K)의 값이 500 미만으로 된다면 다른 조합 탐색
        if(sum<500) return;
        
        // N일 까지 운동 키트를 모두 사용했다는 의미이므로 count
        if(depth==N) {
            answer++;
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){ // 방문하지 않았다면
                visited[i] = true; // 방문 표시
                solve(depth+1, sum+arr[i]-K); // 재귀 함수
                visited[i] = false; // 미방문 표시
            }
        }
    }
}



