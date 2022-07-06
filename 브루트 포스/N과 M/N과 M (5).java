import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 15654번 - N과 M (5) (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 06
*    메모리 : 28616 KB
*    시간 : 312 ms
 */

public class Main {
    private static int N, M;
    private static int[] arr; // N개의 수를 저장할 배열
    private static int[] arr2; // M개의 수를 저장할 배열
    private static boolean[] visited; // 방문 표시
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        arr2 = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 출력하기 위해 정렬
        Arrays.sort(arr);

        dfs(0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int depth){
        if(depth == M){
            for(int val : arr2){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){ // 방문하지 않은 곳이면
                visited[i] = true; // 방문 표시
                arr2[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false; // 방문한 곳을 false 로 복구
            }
        }
    }
}

