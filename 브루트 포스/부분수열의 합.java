import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1182번 - 부분수열의 합 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 07 - 09
*    메모리 : 14356 KB
*    시간 : 132 ms
 */

public class Main {
    private static int N, S;
    private static int[] arr;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 정수의 합

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        if(S==0) bw.write(count-1+"");
        else bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int depth, int sum){
        if(depth == N){
            if(sum == S){
                count++;
            }
            return;
        }

        dfs(depth+1, sum+arr[depth]);
        dfs(depth+1, sum);
    }

}

