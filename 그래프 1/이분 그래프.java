import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 1707번 - 이분 그래프 (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 26
*    메모리 : 271184 KB
*    시간 : 992 ms
 */
public class Main {
    // 정점의 개수, 간선의 개수
    private static int N, M;
    // 방문 표시
    private static int[] visited;
    private static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t=0; t<T; t++){
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N+1];
            visited = new int[N+1];

            for(int i=0; i<N+1; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            String answer = bfs();

            bw.write(answer+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
    public static String bfs(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<N+1; i++){
            // 방문 처리
            if(visited[i]==0){
                queue.add(i);
                // 초기에 1로 저장
                visited[i] = 1;
            }

            // 노드 탐색
            while(!queue.isEmpty()){
                int q = queue.poll();

                // 인접한 노드를 먼저 탐색
                for(int j=0; j<list[q].size(); j++){
                    if(visited[list[q].get(j)] == 0){
                        queue.add(list[q].get(j));
                    }

                    // 인접한 노드가 같은 그룹의 정점일 경우
                    if(visited[list[q].get(j)] == visited[q]){
                        return "NO";
                    }

                    // 인접한 노드를 방문한 적이 없고 그룹이 1일 경우
                    if(visited[list[q].get(j)]==0 && visited[q]==1){
                        // 인접한 노드는 2 그룹으로 저장
                        visited[list[q].get(j)] = 2;
                    } else if(visited[list[q].get(j)]==0 && visited[q]==2){
                        // 인접한 노드는 1 그룹으로 저장
                        visited[list[q].get(j)] = 1;
                    }
                }
            }
        }
        return "YES";
    }

}

