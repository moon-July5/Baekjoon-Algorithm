import java.io.*;
import java.util.*;


/*   Baekjoon 17086번 - 아기 상어 2 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 09
*    메모리 : 14820 KB
*    시간 : 148 ms
 */

public class Main {
    private static int N, M; // 공간의 세로, 가로 크기
    private static int[][] arr; // 0은 빈 칸, 1은 아기 상어가 있는 칸
    private static int[][] visited; // 방문 표시
    private static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1}; // x축 8방향
    private static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0}; // y축 8방향
    private static Queue<int[]> queue = new LinkedList<>();
    private static int max = Integer.MIN_VALUE; // 안전 거리의 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new int[N][M];

        // 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) // 아기 상어가 있는 칸이면
                    queue.add(new int[] {i, j}); // 큐에 삽입
            }
        }

        bfs();

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 방식
    public static void bfs() {
        while (!queue.isEmpty()){
            int[] node = queue.poll();

            for(int i=0; i<8; i++){
                int y = node[0] + dy[i];
                int x = node[1] + dx[i];

                if(x>=0 && y>=0 && x<M && y<N){ // N X M 크기의 범위 안에서만 이동할 수 있어야함
                    if(visited[y][x]==0 && arr[y][x]==0){ // 방문하지 않았고 빈 칸 일 경우 (아기 상어가 있는 칸이 아닐 경우)
                        visited[y][x] = visited[node[0]][node[1]] + 1; // 방문하면서 +1
                        max = Math.max(max, visited[y][x]); // 안전 거리 최댓값 갱신
                        queue.add(new int[] {y, x});
                    }
                }
            }
        }
    }

}

