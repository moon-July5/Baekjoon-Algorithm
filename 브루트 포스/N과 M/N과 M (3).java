import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 15651번 - N과 M (3) (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 06
*    메모리 : 69164 KB
*    시간 : 472 ms
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

        dfs(0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        /*
            중복을 허용한다고 하였기 때문에 방문 처리할 필요 없이 
            depth 만을 +1을 하여 재귀호출 한다.
         */
        for(int i=0; i<N; i++){
            arr[depth] = i+1;
            dfs(depth+1);
        }
    }

}

