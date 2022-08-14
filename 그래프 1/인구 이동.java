import java.io.*;
import java.util.*;


/*   Baekjoon 16234번 - 인구 이동 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 14
*    메모리 : 297336 KB
*    시간 : 576 ms
 */
class Node {
    int x, y;

    public Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class Main {
    private static int N, L, R; // 땅 크기, 인구 차이(L명 이상 R명 이하)
    private static int[][] arr;
    private static ArrayList<Node> list;
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        // 각 나라의 인구수 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while(true){
            visited = new boolean[N][N];
            boolean flag = false;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){ // 방문하지 않았다면
                        int sum = bfs(i, j); // 연합을 이루고 있는 인구수를 모두 더함
                        if(list.size() > 1) { // 연합의 수가 1 이상이어야 한다.
                            change(sum); // 연합을 이루고 있는 각 칸의 인구수를 바꾼다.
                            flag = true;
                        }
                    }
                }
            }
            if(!flag) break;
            answer++;
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 탐색
    public static int bfs(int a, int b){
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();

        queue.add(new Node(a, b));
        list.add(new Node(a, b));

        visited[a][b] = true;

        int sum = arr[a][b]; // 연합의 인구 수

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<4; i++){
                int y = node.y + dy[i];
                int x = node.x + dx[i];

                // 땅 크기 안의 범위 에서만 이동할 수 있어야 하며,
                if(x>=0 && y>=0 && x<N && y<N){
                    // 방문한 적이 없고
                    if(!visited[y][x]){
                        int diff = Math.abs(arr[node.y][node.x] - arr[y][x]); // 인접한 땅의 인구수의 차이
                        // 인구수 차이가 L명 이상 R명 이하면
                        if(diff>=L && diff<=R){
                            visited[y][x] = true; // 방문 표시
                            queue.add(new Node(y, x)); // 다음에 이동할 좌표 저장
                            list.add(new Node(y, x)); // 연합의 수와 좌표를 저장하기 위해
                            sum += arr[y][x]; // 인접한 땅의 인구수를 더한다.
                        }
                    }
                }
            }
        }

        return sum;
    }

    // 연합을 이루고 있는 각 칸의 인구수를 바꾼다.
    public static void change(int sum) {
        int avg = sum / list.size(); // 연합을 이루고 있는 칸의 평균 값

        for(Node node : list)
            arr[node.y][node.x] = avg; // 연합을 이루고 있는 각 칸의 인구수를 바꾼다.
    }
}


