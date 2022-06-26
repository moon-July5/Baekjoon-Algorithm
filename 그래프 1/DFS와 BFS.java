import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 1260번 - DFS와 BFS (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 26
*    메모리 : 24688 KB
*    시간 : 388 ms
 */
public class Main {
    // 정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호
    private static int N, M, V;
    private static int[][] arr;
    private static boolean[] visited; // 방문 표시
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

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
        dfs(V);
        System.out.println();

        // BFS 탐색을 위한 초기화
        visited = new boolean[N+1];

        bfs(V);

        //bw.close();
        br.close();
    }
    // DFS 방식
    public static void dfs(int start){
        // 방문 표시
        visited[start] = true;

        // 방문한 노드 출력
        System.out.print(start+" ");

        // 방문할 노드 탐색
        for(int i=1; i<N+1; i++){
            // 다음 노드에 방문한 적이 없고 연결되어 있을 때
            if(!visited[i] && arr[start][i]==1){
                dfs(i);
            }
        }
    }
    // BFS 방식
    public static void bfs(int start){
        // Queue 를 이용한 구현
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // 방문 표시
        visited[start] = true;

        // 방문할 노드 탐색
        while(!queue.isEmpty()){
            int q = queue.poll();

            // 방문한 노드 출력
            System.out.print(q+" ");

            // Queue 에 삽입한 노드에서 인접한 곳을 탐색
            for(int i=1; i<N+1; i++){
                if(!visited[i] && arr[q][i]==1){
                    queue.add(i);
                    visited[i] = true;
                }
            }

        }
    }

}

