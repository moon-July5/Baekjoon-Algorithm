import java.io.*;
import java.util.*;


/*   Baekjoon 24444번 - 알고리즘 수업 - 너비 우선 탐색 1 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 11
*    메모리 : 95072 KB
*    시간 : 1120 ms
 */

public class Main {
    private static int N, M, R; // 정점의 수, 간선의 수, 시작 정점 번호
    private static int[] visited; // 방문 표시
    private static ArrayList<Integer>[] list;
    private static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new int[N+1];

        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // 인접 접점에 오름차순으로 방문하기 위해 오름차순으로 정렬
       for(int i=1; i<=N; i++)
            Collections.sort(list[i]);

        bfs(R); // BFS 탐색

        for(int i=1; i<=N; i++)
            bw.write(visited[i]+"\n");
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 방식
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 시작 정점 번호 queue에 push

        visited[start] = count++;

        while(!queue.isEmpty()){
            int node = queue.poll(); // 큐에 들어있는 노드들을 pop

            // 인접 노드들을 먼저 탐색
            for(int next : list[node]){
                // 다음에 이동할 노드를 방문하지 않았다면
                if(visited[next]==0){
                    visited[next] = count++; // count로 방문 표시
                    queue.add(next); // 큐에 삽입
                }
            }
        }
    }
}

