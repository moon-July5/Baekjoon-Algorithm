import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 14889번 - 스타트와 링크 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 07 - 08
*    메모리 : 21076 KB
*    시간 : 364 ms
 */

public class Main {
    private static int N;   // 사람 수
    private static int[][] arr;
    private static boolean[] visited; // 방문 표시
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(min+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int depth, int count){
        // 팀 조합이 완성된 경우
        if(count == N/2){
            // 방문한 팀과 방문하지 않은 팀으로 나누어 점수 차이를 계산
            diff();

            return;
        }

        for(int i=depth; i<N; i++){
            // 방문하지 않았다면
            if(!visited[i]){
                visited[i] = true; // 방문 표시
                dfs(i+1, count+1);
                visited[i] = false; // 재귀 호출이 끝나면 다시 미방문 처리
            }
        }
    }

    // 두 팀의 차이를 계산하는 메서드
    public static void diff() {
        int group1 = 0;
        int group2 = 0;

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                // i번째 사람과 j번째 사람이 true 라면 group1에 점수 계산
                if(visited[i] && visited[j]){
                    group1 += arr[i][j];
                    group1 += arr[j][i];
                }
                // i번째 사람과 j번째 사람이 false 라면 group2에 점수 계산
                else if(!visited[i] && !visited[j]){
                    group2 += arr[i][j];
                    group2 += arr[j][i];
                }
            }
        }

        // 두 팀의 차이 계산
        int diff = Math.abs(group1 - group2);

        // 두 팀의 차이가 0이라면 최소가 0이기 때문에 더 탐색할 필요없이 종료
        if(diff==0){
            System.out.println(diff);
            System.exit(0);
        }
        min = Math.min(min, diff);
    }
}

