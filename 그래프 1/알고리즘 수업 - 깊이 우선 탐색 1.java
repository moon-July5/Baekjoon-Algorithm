import java.io.*;
import java.util.*;


/*   Baekjoon 24479번 - 알고리즘 수업 - 깊이 우선 탐색 1 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 11
*    메모리 : 90876 KB
*    시간 : 1116 ms
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

        // 인접 정점을 오름차순으로 방문하기 위해 오름차순으로 정렬
        for(int i=1; i<=N; i++)
            Collections.sort(list[i]);

        dfs(R); // DFS 탐색

        for(int i=1; i<=N; i++)
            bw.write(visited[i]+"\n");
        bw.flush();

        bw.close();
        br.close();
    }
    // DFS 방식
    public static void dfs(int start){
        visited[start] = count;

        for(int i=0; i<list[start].size(); i++){
            int node = list[start].get(i); // 인접 노드 조회

            if(visited[node]==0){ // 인접 노드에 방문하지 않았따면
                count++;
                dfs(node);
            }
        }
    }
}

