import java.io.*;
import java.util.*;

/*   Baekjoon 16947번 - 서울 지하철 2호선 (Gold Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 27
*    메모리 : 233064 KB
*    시간 : 828 ms
 */
public class Main {
    private static int N;   // 역의 개수
    private static boolean[] isCycle; // cycle 존재 여부 확인
    private static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];

        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        // 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 저장
            list[a].add(b);
            list[b].add(a);
        }

        isCycle = new boolean[N+1];

        // cycle 이 존재하는지 탐색
        for(int i=1; i<N+1; i++){
            if(dfs(i,i,i)) break;
            isCycle = new boolean[N+1];
        }

        int[] answer = new int[N+1];

        // cycle 이 발생한 노드까지의 거리 계산
        for(int i=1; i<N+1; i++){
            if(!isCycle[i]) answer[i] = bfs(i);
        }

        // 출력
        for(int i=1; i<N+1; i++) bw.write(answer[i]+" ");
        bw.flush();

        bw.close();
        br.close();
    }

    // cycle 이 존재하는지 DFS 방식으로 확인
    // 전에 방문했던 노드, 현재 노드, 시작 노드
    public static boolean dfs(int prev, int n, int start){
        isCycle[n] = true; // 현재 노드 방문 처리

        // 현재 노드와 연결된 인접한 노드 탐색
        for(int i=0; i<list[n].size(); i++){
            int next = list[n].get(i);

            // 인접한 노드 중에 방문하지 않은 노드가 존재하면 방문
            if(!isCycle[next]){
                if(dfs(n, next, start)) return true;
              // 인접한 노드가 이전에 방문한 노드가 아니고 시작 노드라면 cycle 이 존재하는 것이기 때문에 true 반환
            } else if(next != prev && next == start) return true;
        }

        isCycle[n] = false;

        return false;
    }

    // cycle 이 발생한 노드까지의 거리 계산
    public static int bfs(int n) {
        boolean[] visited = new boolean[N+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0});

        visited[n] = true;

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            // cycle에 포함된 노드를 발견하면 count 반환
            if(isCycle[node[0]]) return node[1];

            for(int i=0; i<list[node[0]].size(); i++){
                int next = list[node[0]].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new int[] {next, node[1]+1});
                }
            }
        }
        return 0;
    }
}

