import java.io.*;
import java.util.*;


/*   Baekjoon 18352번 - 특정 거리의 도시 찾기 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 08
*    메모리 : 336984 KB
*    시간 : 1444ms
 */
class Node implements Comparable<Node>{
    int end, distance;

    public Node(int end, int distance){
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}
public class Main {
    private static int N, M, K, X; // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 번호
    private static ArrayList<ArrayList<Node>> list;
    private static boolean[] visited; // 방문 표시
    private static int[] d; // 최단 거리 테이블
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도르의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        list = new ArrayList<>();

        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        visited = new boolean[N+1];
        d = new int[N+1];

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, 1));
        }

        Arrays.fill(d, Integer.MAX_VALUE); // 최단 거리 테이블의 모든 공간을 최댓값으로 초기화
        d[X] = 0; // 출발 지점은 0

        dijkstra(); // 다익스트라 호출

        boolean flag = false; // 거리 정보와 일치하는 값이 있는 지 확인

        for(int i=1; i<=N; i++){
            // 거리 정보와 일치하는 값을 출력
            if(d[i] == K) {
                bw.write(i + "\n");
                flag = true;
            }
        }

        if(!flag) // 거리 정보와 일치하는 값이 없으면 -1 출력
            bw.write(-1+"");

        bw.flush();

        bw.close();
        br.close();
    }

    // 다익스트라
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));

        while (!pq.isEmpty()){
            Node node = pq.poll();

            int now = node.end;

            // 방문하지 않았으면
            if(!visited[now]){
                visited[now] = true;

                // 인접한 노드 탐색
                for(Node n : list.get(now)){
                    // 어떤 노드를 거쳐가는 거리 값보다 그냥 도착 지점으로 가는 거리 값이 크다면
                    if(d[n.end] > d[now] + n.distance){
                        d[n.end] = d[now] + n.distance; // 최단 거리 갱신
                        pq.add(new Node(n.end, d[n.end]));
                    }
                }
            }
        }
    }
}

