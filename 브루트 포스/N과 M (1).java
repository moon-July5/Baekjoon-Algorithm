import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 15649번 - N과 M (1) (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 05
*    메모리 : 23308 KB
*    시간 : 264 ms
 */

public class Main {
    private static int N, M;
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];

        dfs(0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int depth){
        // 길이가 M일 경우 StringBuilder 를 통해 값 저장
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            // 방문하지 않았으면
            if(!visited[i]){
                visited[i] = true; // 방문 표시
                arr[depth] = i+1; // 배열에 값 저장
                dfs(depth+1); // 재귀 호출
                visited[i] = false; // 방문이 끝나고 돌아오면 방문하지 않은 상태로 변경
            }
        }
    }

}

