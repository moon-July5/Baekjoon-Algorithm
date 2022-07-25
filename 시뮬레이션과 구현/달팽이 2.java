import java.io.*;
import java.util.*;

/*   Baekjoon 1952번 - 달팽이 2 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 25
*    메모리 : 14328 KB
*    시간 : 128 ms
 */

public class Main {
    private static int[] dx = {0, 1, 0, -1}; // x축 이동
    private static int[] dy = {-1, 0, 1, 0}; // y축 이동
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 세로
        int N = Integer.parseInt(st.nextToken()); // 가로

        boolean[][] visited = new boolean[M][N]; // 방문 표시

        int dir = 1; // 방향 변수
        int x=0; int y=0;
        int count = 0;

        while(true){
            if(visited[y][x]) break;

            visited[y][x] = true; // 방문 표시

            // 다음에 이동할 곳
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            // 영역을 벗어나거나 이미 방문했던 곳이라면 꺾어진 부분으로 구분함
           if(nextX<0 || nextY<0 || nextX>=N || nextY>=M || visited[nextY][nextX]){
                if(dir==3) dir = 0; // 방향 초기화
                else dir++; // 방향 변경

                count++; 
            }

            x = x + dx[dir];
            y = y + dy[dir];
        }
        bw.write(count-1+"");
        bw.flush();

        bw.close();
        br.close();
    }
}

