import java.io.*;
import java.util.*;


/*   Baekjoon 1303번 - 전쟁-전투 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 13
*    메모리 : 17940 KB
*    시간 : 172 ms
 */

public class Main {
    private static int N, M; // 전쟁터의 가로, 세로크기
    private static char[][] arr;
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[M][N];
        visited = new boolean[M][N];

        // 병사들의 옷 색 입력
        for(int i=0; i<M; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        int W=0, B=0; // 흰색, 파란색 개수

        // BFS 탐색
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){ // 방문하지 않았으면
                    count = 1; // 초기 count
                    bfs(i, j, arr[i][j]); // BFS 탐색

                    if(arr[i][j]=='W') // 힌색 옷이면
                        W += (count * count);
                    else if(arr[i][j]=='B') // 파란색 옷이면
                        B += (count * count);
                }
            }
        }

        bw.write(W +" "+B);
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 탐색
    public static void bfs(int a, int b, char c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});

        visited[a][b] = true;

        while (!queue.isEmpty()){
            int[] node = queue.poll();

            for(int i=0; i<4; i++){
                int y = node[0] + dy[i];
                int x = node[1] + dx[i];

                // 전쟁터 크기 안에서만 탐색할 수 있으며
                if(x>=0 && y>=0 && x<N && y<M){
                    // 방문하지 않았고 병사의 옷 색이 똑같으면
                    if(!visited[y][x] && arr[y][x]==c){
                        visited[y][x] = true; // 방문 표시
                        count++; // 옷의 개수 count
                        queue.add(new int[] {y, x, c}); // 다음 좌표 저장
                    }
                }
            }
        }
    }
}

