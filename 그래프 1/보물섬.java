import java.io.*;
import java.util.*;


/*   Baekjoon 2589번 - 보물섬 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 16
*    메모리 : 295116 KB
*    시간 : 508 ms
 */
class Node {
    int x, y, distance;

    public Node(int y, int x, int distance){
        this.y = y;
        this.x = x;
        this.distance = distance;
    }
}

public class Main {
    private static int N, M; // 보물 지도의 세로 크기, 가로 크기
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        // 보물 지도 입력력
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int answer = 0;

        // BFS 탐색
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]=='L'){ // 육지라면
                    visited = new boolean[N][M];
                    int dis = bfs(i, j);
                    answer = Math.max(answer, dis);
                }
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 탐색
    public static int bfs(int a, int b){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, b, 0));

        visited[a][b] = true;

        int dis = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<4; i++){
                int y = node.y + dy[i];
                int x = node.x + dx[i];

                // 보물 지도의 범위 안에서만 이동할 수 있으며,
                if(x>=0 && y>=0 && x<M && y<N){
                    // 방문하지 않았고 다음에 이동할 위치가 육지라면
                    if(!visited[y][x] && arr[y][x]=='L'){
                        visited[y][x] = true; // 방문 표시
                        queue.add(new Node(y, x, node.distance+1)); // 다음에 이동할 좌표 저장
                        dis = Math.max(dis, node.distance+1);
                    }
                }
            }
        }

        return dis; // 거리 반환
    }

}


