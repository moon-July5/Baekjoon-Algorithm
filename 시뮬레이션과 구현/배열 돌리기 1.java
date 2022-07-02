import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 16926번 - 배열 돌리기 1 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 02
*    메모리 : 30440 KB
*    시간 : 884 ms
 */

public class Main {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1 ,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열의 행
        int M = Integer.parseInt(st.nextToken()); // 배열의 열
        int R = Integer.parseInt(st.nextToken()); // 회전 수

        int[][] arr = new int[N][M];

        // 배열 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
            회전해야 하는 그룹 개수
            예를 들어, 2X2 행렬에서 1개의 그룹만 회전하면 되며, 5X5 행렬에서는 바깥 쪽, 안쪽 2개의 그룹을 회전해야 한다.

            이는 행과 열의 길이 중에서 최솟값 / 2를 나누면 그룹 개수가 나온다.
         */
        int value = Math.min(N, M) / 2;

        // 회전 횟수
        for(int r=0; r<R; r++){
            // 회전해야 하는 그룹의 개수만큼 반복
            for(int v=0; v<value; v++){
                int x = v; int y = v; // 시작 값

                int temp = arr[y][x]; // 회전하면서 값을 덮어씌울수 있기 때문에 따로 값을 저장

                int dir = 0;    // 방향

                while(dir<4){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    // 범위 내에 있어야 함
                    if(nx>=v && ny>=v && nx<N-v && ny<M-v){
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    } else
                        dir++;  // 방향 전환
                }
                // 따로 저장된 값을 불러와서 저장
                arr[v+1][v] = temp;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                bw.write(arr[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

}

