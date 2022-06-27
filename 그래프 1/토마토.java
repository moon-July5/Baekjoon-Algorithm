import java.io.*;
import java.util.*;

/*   Baekjoon 7576번 - 토마토 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 27
*    메모리 : 119304 KB
*    시간 : 676 ms
 */
public class Main {
    private static int M, N; // 상자의 가로, 세로
    private static int[] dx = {0, 1, 0, -1};    // x축 이동
    private static int[] dy = {1, 0, -1, 0};    // y축 이동
    private static int[][] arr;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 토마토가 모두 익는데 걸리는 최소 일수 구하기
        count = bfs();

        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 방식
    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 익은 토마토가 있는 곳을 모두 Queue 에 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 익은 토마토 주변에 안 익은 토마토들을 익게 하기 
        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            for (int i = 0; i < 4; i++) {
                int y = q[0] + dy[i];
                int x = q[1] + dx[i];

                // 토마토 상자 크기의 범위 안에만 이동해야 하며
                if (x >= 0 && y >= 0 && x < M && y < N) {
                    // 익지 않은 토마토일 경우
                    if (arr[y][x] == 0) {
                        queue.add(new int[]{y, x});
                        // 익는데 걸리는 일수 갱신
                        arr[y][x] = arr[q[0]][q[1]] + 1;
                    }
                }
            }
        }

        int max = 0;

        // 토마토가 모두 익지 못했다면 -1 반환
        // 그리고 토마토가 모두 익는데 걸리는 일수 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        return max - 1;
    }
}

