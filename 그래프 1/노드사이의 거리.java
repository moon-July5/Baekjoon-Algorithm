import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 1240번 - 노드사이의 거리 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 26
*    메모리 : 53668 KB
*    시간 : 356 ms
 */

class Node {
    int to, distance;

    public Node(int to, int distance){
        this.to = to;
        this.distance = distance;
    }
}

public class Main {
    private static int N, M; // 노드의 개수, 거리를 알고싶은 노드 쌍의 개수
    private static ArrayList<Node>[] list;
    private static boolean[] visited; // 방문 표시
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        // 두 노드 간의 거리 입력
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, distance));
            list[b].add(new Node(a, distance));
        }

        // BFS 탐색을 통해 두 노드 간의 거리 출력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(bfs(start, end)+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 탐색
    public static int bfs(int start, int end) {
        visited = new boolean[N+1];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));

        visited[start] = true; // 방문 표시

        int dist = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();

            if(node.to == end) { // 목적노드에 도착했으면 거리를 반환 후 종료
                dist = node.distance;
                break;
            }

            for(Node next : list[node.to]){ // 인접한 노드로 이동
                if(!visited[next.to]){ // 방문하지 않은 노드라면
                    queue.add(new Node(next.to, node.distance+next.distance)); // 다음 노드 정보 저장
                    visited[next.to] = true; // 방문 표시
                }
            }
        }

        return dist;
    }
}


