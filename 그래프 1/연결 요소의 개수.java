import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11724번 - 연결 요소의 개수 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 26
*    메모리 : 116420 KB
*    시간 : 540 ms
 */
public class Main {
    // 정점의 개수, 간선의 개수
    private static int N,M;
    // 방문 표시
    private static boolean[] visited;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 양방향 저장
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int count = 0;

        for(int i=1; i<N+1; i++){
            if(!visited[i]){
                dfs(i);
                // dfs() 메서드의 재귀 호출이 끝났으면 count
                count++;
            }
        }
        
        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }
    // DFS 탐색
    public static void dfs(int start){
        // 방문한 노드 방문 표시
        visited[start] = true;

        // 노드 탐색
        for(int i=1; i<N+1; i++){
            // 방문한 적이 없는 노드이고 연결되어 있으면
            if(!visited[i] && arr[start][i]==1){
                dfs(i);
            }
        }

    }
}

