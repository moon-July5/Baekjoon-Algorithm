import java.io.*;
import java.util.*;

/*   Baekjoon 1261번 - 알고스팟 (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 29
*    메모리 : 101964 KB
*    시간 : 728 ms
 */
class Node implements Comparable<Node> {
    int x;  // x축
    int y;  // y축
    int count; // 벽을 부순 개수

    Node(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        return count - o.count;
    }
}

public class Main {
    private static int M, N; // 미로의 가로, 세로 크기
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1}; // x축 이동
    private static int[] dy = {1, 0, -1 ,0}; // y축 이동
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        // BFS 탐색 후 출력
        bw.write(bfs(0,0)+"");
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 방식
    public static int bfs(int a, int b){
        // 벽을 부순 개수를 오름차순으로 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a,b,0));

        visited[a][b] = true;

        while (!pq.isEmpty()){
            Node node = pq.poll();

            int nodeY = node.y; int nodeX = node.x; int count = node.count;

            // 목적지에 도착했으면
            if(nodeX==M-1 && nodeY==N-1){
                return count;
            }

            for(int i=0; i<4; i++){
                int y = nodeY + dy[i];
                int x = nodeX + dx[i];

                // 주어진 크기 안 에서만 이동할 수 있으며
                if(x>=0 && y>=0 && x<M && y<N){
                    // 다음에 이동할 곳을 방문하지 않았고 빈 방이면
                    if(!visited[y][x] && arr[y][x]==0){
                        visited[y][x] = true;
                        pq.add(new Node(y, x, count));
                    }

                    // 다음에 이동할 곳을 방문하지 않았고 벽이라면
                    if(!visited[y][x] && arr[y][x]==1){
                        visited[y][x] = true;
                        pq.add(new Node(y, x, count+1));
                    }
                }

            }
        }
        return 0;
    }
}

