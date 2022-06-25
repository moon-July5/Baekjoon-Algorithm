import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*   Baekjoon 13023번 - ABCDE (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 25
*    메모리 : 21744 KB
*    시간 : 292 ms
 */
public class Main {
    private static ArrayList<Integer>[] list;
    private static boolean[] visited; // 방문 표시
    private static int answer = 0; // 조건에 맞는 존재를 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수

        list = new ArrayList[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++)
            list[i] = new ArrayList<>();

        // 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // ArrayList 에 양방향 저장
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0; i<N; i++){
            if(answer==0)
                dfs(i,1);
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // DFS 방식
    public static void dfs(int start, int depth){
        if(depth==5){
            answer = 1;
            return;
        }

        // 방문 표시
        visited[start] = true;

        // 인접한 노드 방문
        for(int val : list[start]){
            int next = val;

            if(!visited[next]){
                dfs(next, depth+1);
            }
        }

        // 더 방문할 곳이 없다면 방문했던 곳들을 미방문 처리
        visited[start] = false;
    }


}

