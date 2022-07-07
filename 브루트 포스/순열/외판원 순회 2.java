import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 10971번 - 외판원 순회 2 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 07 - 07
*    메모리 : 15644 KB
*    시간 : 204 ms
 */

public class Main {
    private static int N;   // 도시의 수
    private static int[][] arr;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];

        // 비용 행렬 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;

        dfs(0, 0, 0, 1);

        bw.write(min +" ");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int start, int now, int cost, int depth){
        // 모든 도시를 순회했을 경우
       if(now == start && cost > 0){
           min = Math.min(min, cost);
           return;
       }

       for(int i=0; i<N; i++){
           // 현재 위치에 있는 도시가 아니면
           if(arr[now][i] > 0){
               // 가려는 도시가 시작 도시이고, 모든 도시를 방문한 상태이면
                if(i == start && depth == N){
                    cost += arr[now][i];
                    dfs(start, i, cost, depth+1);
                }
                // 방문하지 않은 도시이면
                else if(!visited[i]){
                    visited[i] = true;
                    cost += arr[now][i];
                    dfs(start, i, cost, depth+1);
                    cost -= arr[now][i];
                    visited[i] = false;
                }
           }
       }

    }
}

