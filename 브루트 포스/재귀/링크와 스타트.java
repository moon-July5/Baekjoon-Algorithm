import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 15661번 - 링크와 스타트 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 08
*    메모리 : 21316 KB
*    시간 : 652 ms
 */

public class Main {
    private static int N;
    private static int[][] arr;
    private static boolean[] visited; // 방문 표시
    private static int p; // 사람 수를 표시
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

        // p는 사람 수를 나타낸다. 가능한 모든 경우의 수를 탐색
        for(p=1; p<N; p++){
            dfs(0, 0);
        }
        
        bw.write(min+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int n, int depth){
        if(depth==p){
            diff();

            return;
        }

        for(int i=n; i<N; i++){
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }

    // 두 팀의 차이를 계산하는 메서드
    public static void diff(){
        int group1 = 0;
        int group2 = 0;

        for(int i=0; i<N-1; i++){
            for(int j=i; j<N; j++){
                if(visited[i] && visited[j]){
                    group1 += arr[i][j];
                    group1 += arr[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    group2 += arr[i][j];
                    group2 += arr[j][i];
                }
            }
        }

        int diff = Math.abs(group1 - group2);

        // 차이가 0이면 더 이상 탐색할 필요 없이 0을 출력하고 종료한다.
        if(diff==0){
            System.out.println(diff);
            System.exit(0);
        }

        min = Math.min(min, diff);
    }

}

