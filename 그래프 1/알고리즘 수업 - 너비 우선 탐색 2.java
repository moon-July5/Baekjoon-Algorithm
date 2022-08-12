import java.io.*;
import java.util.*;


/*   Baekjoon 24445번 - 알고리즘 수업 - 너비 우선 탐색 2 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 12
*    메모리 : 92740 KB
*    시간 : 1144 ms
 */

public class Main {
    private static int N, M, R; // 정점의 수, 간선의 수, 시작 정점 번호
    private static ArrayList<Integer>[] list;
    private static int[] visited; // 방문 표시
    private static int seq = 1;
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

        // 인접 정점을 내림차순으로 방문하기 위해 내림차순으로 정렬
        for(int i=1; i<=N; i++)
            Collections.sort(list[i], Collections.reverseOrder());

        bfs(R);

        for(int i=1; i<=N; i++)
            bw.write(visited[i]+"\n");
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 탐색
   public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = seq++;

        while (!queue.isEmpty()){
            int node = queue.poll();

            for(int i=0; i<list[node].size(); i++){
                int next = list[node].get(i);

                if(visited[next]==0){
                    visited[next] = seq++;
                    queue.add(next);
                }
            }
        }
   }
}

