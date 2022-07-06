import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 15652번 - N과 M (4) (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 06
*    메모리 : 18436 KB
*    시간 : 156 ms
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

        dfs(1, 0);

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

        /*
            비내림차순으로 출력하기 위해 for 문 안에 i의 초기 값을 n 값으로 주며,
            이 n은 1부터 시작한다. 재귀 호출로 i 값을 넘겨줌으로써 첫 번째는 1부터 N까지 선택,
            두 번째는 2부터 N까지 선택하여 출력한다.
         */
        for(int i=n; i<=N; i++){
            arr[depth] = i;
            dfs(i, depth+1);
        }
    }

}

