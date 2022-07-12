import java.io.*;
import java.util.*;

/*   Baekjoon 4485번 - 녹색 옷 입은 애가 젤다지? (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 07 - 12
*    메모리 : 20060 KB
*    시간 : 288 ms
 */
class Node implements Comparable<Node>{
    int x, y, lost;

    public Node(int x, int y, int lost){
        this.x = x;
        this.y = y;
        this.lost = lost;
    }

    // 가장 비용이 작은 것이 높은 우선 순위로
    @Override
    public int compareTo(Node o) {
        return this.lost - o.lost;
    }
}

public class Main {
    private static int N;   // 동굴의 크기
    private static int[][] thief;   // 도둑루피의 크기가 저장된 배열
    private static int[][] d;   // 최소 금액 테이블
    private static int[] dx = {0, 1, 0, -1};    // x축 이동
    private static int[] dy = {1, 0, -1, 0};    // y축 이동
    private static int idx = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while((N=Integer.parseInt(br.readLine())) != 0){
            thief = new int[N][N];
            d = new int[N][N];

            // 도둑루피의 크기 입력
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    thief[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();

            bw.write("Problem "+idx+": "+d[N-1][N-1]+"\n");
            idx++;
        }
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 방식
    public static void bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, thief[0][0]));

        for(int i=0; i<N; i++) Arrays.fill(d[i], Integer.MAX_VALUE);

        d[0][0] = thief[0][0];

        while(!pq.isEmpty()){
            Node node = pq.poll();

            for(int i=0; i<4; i++){
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                // 동굴 크기 안에서만 이동해야 하며
                if(x>=0 && y>=0 && x<N && y<N){
                    // 현재 잃어버리는 금액보다 작다면 최소 금액이니 갱신한다.
                    if(d[x][y] > d[node.x][node.y] + thief[x][y]){
                        d[x][y] = d[node.x][node.y] + thief[x][y];    // 갱신
                        pq.add(new Node(x, y, d[x][y]));
                    }
                }
            }
        }
    }
}

