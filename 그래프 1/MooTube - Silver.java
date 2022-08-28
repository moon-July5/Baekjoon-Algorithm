import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 15591번 - MooTube (Silver) (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 28
*    메모리 : 300688 KB
*    시간 : 1580 ms
 */

class Node {
    int video, usado;

    public Node(int video, int usado){
        this.video = video;
        this.usado = usado;
    }
}

public class Main {
    private static int N, Q;
    private static ArrayList<Node>[] list;
    private static boolean[] visited; // 방문 표시
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        // 두 동영상 쌍의 USADO 입력
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, usado));
            list[b].add(new Node(a, usado));
        }

        // 농부 존의 질문 입력
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken()); // 기준 값
            int V = Integer.parseInt(st.nextToken()); // 동영상 번호

            answer = 0;

            bfs(K, V);

            bw.write(answer+"\n");

        }
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 탐색
    public static void bfs(int k, int v) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(v, Integer.MAX_VALUE));

        visited = new boolean[N+1];

        while(!queue.isEmpty()){
            Node node = queue.poll();

            visited[node.video] = true; // 방문 표시

            // 인접한 노드 탐색
            for(Node next : list[node.video]){
                // 인접한 노드에 발문하지 않았다면
                if(!visited[next.video]){
                    // USADO의 최솟값 갱신
                    int min = Math.min(next.usado, node.usado);

                    // USADO의 값이 기준 값인 K보다 크거나 같다면
                    if(min >= k){
                        answer++;
                        queue.add(new Node(next.video, min));
                        visited[next.video] = true;
                    }
                }
            }
        }

    }

}


