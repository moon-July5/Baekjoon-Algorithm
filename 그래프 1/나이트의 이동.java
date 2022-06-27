import java.io.*;
import java.util.*;

/*   Baekjoon 7562번 - 나이트의 이동 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 27
*    메모리 : 73984 KB
*    시간 : 312 ms
 */
public class Main {
    private static int N;   // 체스판 크기
    private static int x1, y1;  // 나이트가 현재 있는 칸
    private static int x2, y2;  // 나이트가 이동하려고 하는 칸
    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};   // x축 이동
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};   // y축 이동
    private static boolean[][] visited; // 방문 표시
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수

        // 입력
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            visited = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs(y1, x1);

            bw.write(arr[y2][x2]+"\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 방식
    public static void bfs(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});

        visited[a][b] = true;

        while(!queue.isEmpty()){
            int[] q = queue.poll();

            // 나이트가 목적지로 이동했으면 종료
            if(q[0]==y2 && q[1]==x2) break;

            // 8방향 탐색
            for(int i=0; i<8; i++){
                int y = q[0] + dy[i];
                int x = q[1] + dx[i];

                // 체스판 크기의 범위 안에서만 이동할 수 있으며
                if(x>=0 && y>=0 && x<N && y<N){
                    // 방문한 적이 없어야 한다.
                    if(!visited[y][x]){
                        queue.add(new int[] {y, x}); // Queue 에 다음에 이동할 노드 삽입
                        visited[y][x] = true; // 방문 처리
                        arr[y][x] = arr[q[0]][q[1]] + 1; // 이동 거리 계산
                    }
                }
            }
        }
    }

}

