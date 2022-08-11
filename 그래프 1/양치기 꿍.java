import java.io.*;
import java.util.*;


/*   Baekjoon 3187번 - 양치기 꿍 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 11
*    메모리 : 19152 KB
*    시간 : 212 ms
 */

public class Main {
    private static int R, C; // 영역의 세로, 가로 길이
    private static char[][] arr;
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1 ,0};
    private static int k, v; // 양과 늑대
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];

        int sheep=0, wolf=0; // 양과 늑대의 수

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                // 방문하지 않았고 울타리가 아니라면
                if(!visited[i][j] && arr[i][j]!='#'){
                    bfs(i, j); // BFS 탐색
                    sheep += k; // 양의 수를 나타내는 변수에 울타리에 남아있는 양의 수를 누적
                    wolf += v; // 늑대의 수를 나타내는 변수에 울타리에 남아있는 늑대의 수를 누적
                }
            }
        }

        bw.write(sheep+" "+wolf);
        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 방식
    public static void bfs(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});

        visited[a][b] = true;

        k = 0; // 양의 수
        v = 0; // 늑대의 수

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            if(arr[node[0]][node[1]]=='k') k++; // 양이라면
            if(arr[node[0]][node[1]]=='v') v++; /// 늑대라면

            for(int i=0; i<4; i++){
                int y = node[0] + dy[i];
                int x = node[1] + dx[i];

                // 각각 영역 안에서만 탐색해야 한다.
                if(x>=0 && y>=0 && x<C && y<R){
                    // 방문하지 않았고 울타리가 아니라면
                    if(!visited[y][x] && arr[y][x]!='#'){
                        visited[y][x] = true; // 방문 표시
                        queue.add(new int[] {y,x});
                    }
                }
            }
        }

        if(v >= k) k = 0; // 양보다 늑대의 수가 더 많다면 양의 수를 0으로
        else v = 0; // 늑대보다 양의 수가 더 많다면 늑대의 수를 0으로
    }

}

