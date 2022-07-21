import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*   Baekjoon 5567번 - 결혼식 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 07 - 21
*    메모리 : 19048 KB
*    시간 : 200 ms
 */

public class Main {
    private static int n, m; // 상근이의 동기 수, 리스트의 길이
    private static ArrayList<Integer>[] list;
    private static boolean[] visited; /// 방문 표시
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        // 친구 관계 입력
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        visited[1] = true; // 상근이

        dfs(1, 0);

        int count = 0; // 초대할 사람 수

        for(int i=2; i<=n; i++){
            // true일 경우, 초대할 사람 수를 count
            if(visited[i]) count++;
        }

        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // DFS 탐색
    public static void dfs(int start, int depth){
        // 친구의 친구 관계 까지만 탐색
        if(depth == 2) return;

        for(int i=0; i<list[start].size(); i++){
            int next = list[start].get(i);
            visited[next] = true; // 방문 표시
            dfs(next, depth+1);
        }
    }
}

