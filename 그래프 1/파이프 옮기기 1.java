import java.io.*;
import java.util.*;


/*   Baekjoon 17070번 - 파이프 옮기기 1 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 17
*    메모리 : 19028 KB
*    시간 : 248 ms
 */
public class Main {
    private static int N; // 집의 크기
    private static int[][] arr;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];

        // 집의 상태 입력
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);

        bw.write(count+"");

        bw.close();
        br.close();
    }

    // DFS 탐색
    // y - 세로, x - 가로, dir - 파이프의 방향
    public static void dfs(int y, int x, int dir){
        // 파이프가 (N, N) 좌표에 도달했을 경우
        if(x==N && y==N){
            count++;
            return;
        }

        if(dir==0){ // 파이프의 방향이 가로일 경우, 오른쪽으로 이동
            if(x+1<=N && arr[y][x+1]==0){ // 가로로 한 칸 이동했을 때, N보다 작아야 하고 빈 공간이여야 한다.
                dfs(y, x+1, 0);
            }
        } else if(dir==1){ // 파이프의 방향이 세로일 경우, 아래쪽으로 이동
            if(y+1<=N && arr[y+1][x]==0){ // 세로로 한 칸 이동했을 때, N보다 작아야 하고 빈 공간이여야 한다.
                dfs(y+1, x, 1);
            }
        } else if(dir==2){ // 파이프의 방향이 대각선일 경우, 오른쪽 또는 아래쪽으로 이동
            if(x+1<=N && arr[y][x+1]==0){ // 오른쪽 이동
                dfs(y, x+1, 0);
            }

            if(y+1<=N && arr[y+1][x]==0){ // 아래쪽 이동
                dfs(y+1, x, 1);
            }
        }

        // 대각선으로 이동할 경우 - 파이프가 어느 방향이든 대각선으로 옮길 수 있다.
        if(x+1<=N && y+1<=N && arr[y+1][x]==0 && arr[y][x+1]==0 && arr[y+1][x+1]==0){
            dfs(y+1, x+1, 2);
        }
    }
}


