import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 6118번 - 숨바꼭질 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 23
*    메모리 : 32788 KB
*    시간 : 528 ms
 */

public class Main {
    private static int N, M; // 헛간의 수, 관계 수
    private static ArrayList<Integer>[] list;
    private static boolean[] visited;
    private static int idx, dist, count; // 헛간 번호, 거리, 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs();

        bw.write(idx+" "+dist+" "+count);
        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 탐색
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0}); // 현재 노드 값, 거리 값

        visited[1] = true;

        while (!queue.isEmpty()){
            int[] node = queue.poll();

            /*
                만약 현재의 거리 값(node[1])이 결과로 출력할 거리 값(dist)보다 크다면
                멀어질 수록 발냄새가 덜나기 때문에 값을 갱신하고 count도 초기화
             */
            if(node[1] > dist){
                idx = node[0];
                dist = node[1];
                count = 1;
            } else if(node[1] == dist){ // 만약 현재 거리 값이 dist 랑 같으면
                if(idx > node[0]){
                    idx = node[0];
                }
                count++;
            }

            // 인접한 곳 탐색
            for(int i=0; i<list[node[0]].size(); i++){
                int next = list[node[0]].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new int[] {next, node[1]+1});
                }
            }
        }
    }


}

