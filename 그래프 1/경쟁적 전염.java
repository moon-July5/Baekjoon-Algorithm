import java.io.*;
import java.util.*;

/*   Baekjoon 18405번 - 경쟁적 전염 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 21
*    메모리 : 22196 KB
*    시간 : 280 ms
 */

class Node{
    int x, y, virus, time;

    public Node(int y, int x, int virus, int time){
        this.y = y;
        this.x = x;
        this.virus = virus;
        this.time = time;
    }
}
public class Main {
    private static int N, K; // 시험관의 크기, 바이러스의 번호
    private static int S, X, Y; // 시간, 바이러스의 위치(X, Y)
    private static int[] dx = {0, 1, 0, -1}; // x축 이동
    private static int[] dy = {1, 0, -1, 0}; // y축 이동
    private static int[][] arr;
    private static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        ArrayList<Node> list = new ArrayList<>();

        // 시험관의 정보 입력
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) // 바이러스면 list에 저장
                    list.add(new Node(i, j, arr[i][j], 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        // 바이러스를 오름차순으로 저장
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.virus - o2.virus;
            }
        });

        // 오름차순으로 정렬된 시험관의 정보들을 queue에 저장
        for(Node node : list)
            queue.add(node);

        bfs();

        bw.write(arr[X][Y]+"");
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 탐색
    public static void bfs(){

        while(!queue.isEmpty()){
            Node node = queue.poll();

            // 시간이 되면 종료
            if(node.time==S) break;

            // 상하좌우 탐색
            for(int i=0; i<4; i++){
                int y = node.y + dy[i];
                int x = node.x + dx[i];

                // 시험관의 크기 안에서만 이동
                if(x>0 && y>0 && x<=N && y<=N){
                    // 바이러스가 아니면
                    if(arr[y][x]==0){
                        arr[y][x] = node.virus; // 증식
                        queue.add(new Node(y,x, node.virus, node.time+1));
                    }
                }
            }
        }
    }
}


