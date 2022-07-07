import java.io.*;

/*   Baekjoon 10974번 - 모든 순열 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 07
*    메모리 : 22640 KB
*    시간 : 276 ms
 */

public class Main {
    private static int N;
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        dfs(0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int depth){
        if(depth == N){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}

