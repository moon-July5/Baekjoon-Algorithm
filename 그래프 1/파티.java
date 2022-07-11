import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*   Baekjoon 1238번 - 파티 (Gold Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 11
*    메모리 : 18464 KB
*    시간 : 216 ms
 */

class Node implements Comparable<Node> {
    int end;
    int distance;

    public Node(int end, int distance){
        this.end = end;
        this.distance = distance;
    }

    // 가장 거리 비용이 짧은 것이 높은 우선 순위를 가지도록 설정
    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}

public class Main {
    private static int N, M, X; // 학생 수, 단방향 도로 수, 모이는 마을
    private static ArrayList<ArrayList<Node>> toX, fromX;
    private static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        toX = new ArrayList<>();
        fromX = new ArrayList<>();

        for(int i=0; i<=N; i++){
            toX.add(new ArrayList<>());
            fromX.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            // start에서 end로 가는 비용이 distance이다.
            toX.get(start).add(new Node(end, distance));
            fromX.get(end).add(new Node(start, distance));
        }

        int[] d1 = dijkstra(toX); // X에서 시작점들 사이의 최단 거리
        int[] d2 = dijkstra(fromX); // 시작점들에서 X 사이의 최단 거리
        int max = 0;

        for(int i=1; i<=N; i++){
            int dis = d1[i] + d2[i];
            if(dis>max)
                max = dis;
        }

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // 다익스트라
    public static int[] dijkstra(ArrayList<ArrayList<Node>> list){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        boolean[] visited = new boolean[N+1];
        int[] d = new int[N+1]; // 최단 거리 테이블

        Arrays.fill(d, INF); // 최단 거리 테이블을 INF로 저장
        d[X] = 0; // X 마을의 거리는 0

        while(!pq.isEmpty()){
            Node node = pq.poll();

            int now = node.end;

            if(!visited[now]){ // 방문하지 않았을 경우
                visited[now] = true;

                // 현재 노드와 연결된 인접한 노드들을 확인
                for(Node n : list.get(now)){
                    // 방문하지 않았고 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                    if(!visited[n.end] && d[n.end] > d[now] + n.distance){
                        d[n.end] = d[now] + n.distance; // 최단 거리 테이블 갱신
                        pq.add(new Node(n.end, d[n.end]));
                    }
                }
            }
        }
        return d;
    }
}

