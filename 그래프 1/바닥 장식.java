import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 1388번 - 바닥 장식 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 07
*    메모리 : 14496 KB
*    시간 : 148 ms
 */
public class Main {
    private static int N, M; // 방 바닥의 세로 크기, 가로 크기
    private static char[][] deco;
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        deco = new char[N][M];
        visited = new boolean[N][M];

        // 바닥 장식 모양 입력
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                deco[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]) {
                    bfs(i, j);
                    answer++; // count
                }
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j}); // 행, 열 인덱스

        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            // 탐색
            for(int d=0; d<4; d++){
                int y = node[0] + dy[d];
                int x = node[1] + dx[d];

                // 방 바닥 크기 안에서만 탐색
                if(x>=0 && y>=0 && x<M && y<N){
                    // '-' 일 경우
                    if(deco[node[0]][node[1]] == '-'){
                        // 현재 위치와 다음 탐색할 위치와 같은 장식이고 방문하지 않았다면
                        if(deco[node[0]][node[1]] == deco[node[0]][x] && !visited[node[0]][x]){
                            queue.add(new int[] {node[0], x}); // 큐에 그 인덱스를 삽입
                            visited[node[0]][x] = true; // 방문 표시
                        }
                    } else { // '|' 일 경우
                        if(deco[node[0]][node[1]] == deco[y][node[1]] && !visited[y][node[1]]){
                            queue.add(new int[] {y, node[1]});
                            visited[y][node[1]] = true;
                        }
                    }
                }
            }
        }

    }
}

