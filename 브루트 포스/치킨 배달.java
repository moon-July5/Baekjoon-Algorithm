import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*   Baekjoon 15686번 - 치킨 배달 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 10 - 12
*    메모리 : 17564 KB
*    시간 : 240 ms
 */

class Node {
    int x, y; // 좌표 값
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    private static int N,M;
    private static int[][] arr;
    private static boolean[] visited; // 치킨 집 방문 표시
    private static ArrayList<Node> home; // 집 좌표값 저장
    private static ArrayList<Node> chicken; // 치킨 집 좌표값 저장
    private static int answer = Integer.MAX_VALUE; // 도시의 치킨 거리 최솟값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        // 도시 정보 입력
        // 0은 빈 칸, 1은 집, 2는 치킨 집
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j]==1) home.add(new Node(i, j)); // 집이면, 좌표 값 저장
                else if(arr[i][j]==2) chicken.add(new Node(i, j)); // 치킨 집이면, 좌표 값 저장
            }
        }

        // 치킨 집 방문 표시
        visited = new boolean[chicken.size()];

        solve(0, 0);

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // 백트래킹
    public static void solve(int start, int depth){
        if(depth == M){
            int value = 0;

            // 집과 치킨 집과의 거리 계산
            for(int i=0; i<home.size(); i++){
                int temp = Integer.MAX_VALUE;

                // 특정 집과 방문 표시한 치킨 집 사이의 모든 거리 계산
                // 그 후, 최소 거리 갱신
                for(int j=0; j<chicken.size(); j++){
                    if(visited[j]) { // 치킨 집에 방문 표시 했다면
                        int distance = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance); // 집과 치킨 집과의 최소 거리 갱신
                    }
                }
                value += temp; // 도시의 모든 치킨 거리 계산
            }

            answer = Math.min(answer, value);
            return;
        }

        // 치킨 집 방문
        for(int i=start; i<chicken.size(); i++){
            visited[i] = true;
            solve(i+1, depth+1);
            visited[i] = false;
        }
    }
}



