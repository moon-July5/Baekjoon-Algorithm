import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*   Baekjoon 17836번 - 공주님을 구해라! (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 25
*    메모리 : 16224 KB
*    시간 : 180 ms
 */
class Node {
    int x, y, distance;
    boolean isGram;

    public Node(int y, int x, int distance, boolean isGram){
        this.y = y;
        this.x = x;
        this.distance = distance;
        this.isGram = isGram;
    }
}

public class Main {
    private static int N, M, T; // 성의 크기, 공주에게 걸린 저주의 제한 시간
    private static boolean[][][] visited; // 방문 표시, 그람 유무 표시
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2]; // 그람 유무

        // 성의 구조 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = bfs();

        if(answer==-1) bw.write("Fail");
        else bw.write(answer+"");

        bw.close();
        br.close();
    }

    // BFS 탐색
    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, false));

        visited[0][0][0] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            // 공주에게 걸린 저주의 제한 시간이 지났으면 종료
            if(node.distance > T) break;
            // T 시간 내에 공주에게 도달했으면 최소 거리 반환
            if(node.x==M-1 && node.y==N-1) return node.distance;

            for(int i=0; i<4; i++){
                int y = node.y + dy[i];
                int x = node.x + dx[i];

                // 성의 크기 안에서만 이동할 수 있어야 하며
                if(x>=0 && y>=0 && x<M && y<N){
                    if(!node.isGram){ // 그람이 없는 경우
                        if(!visited[y][x][0] && arr[y][x]==0){ // 방문한 적이 없고 빈 공간이면
                            visited[y][x][0] = true;
                            queue.add(new Node(y, x, node.distance+1, node.isGram));
                        } else if(!visited[y][x][0] && arr[y][x]==2){ // 방문한 적이 없고 이동한 곳에 그람이 있으면
                            visited[y][x][0] = true;
                            queue.add(new Node(y, x, node.distance+1, true));
                        }
                    } else { // 그람이 존재하는 경우
                        if(!visited[y][x][1]){ // 방문한 적이 없고 빈 공간이든 벽이 있든 통과 가능
                            visited[y][x][1] = true;
                            queue.add(new Node(y, x, node.distance+1, node.isGram));
                        }
                    }
                }
            }
        }
        return -1;
    }

}


