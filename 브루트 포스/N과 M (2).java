import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 15650번 - N과 M (2) (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 05
*    메모리 : 14288 KB
*    시간 : 132 ms
 */
public class Main {
    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1,0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int n, int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=n; i<=N; i++){
            arr[depth] = i;
            dfs(i+1, depth+1);
        }
    }



}

