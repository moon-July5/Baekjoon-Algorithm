import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 15656번 - N과 M (7) (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 06
*    메모리 : 123580 KB
*    시간 : 640 ms
 */

public class Main {
    private static int N, M;
    private static int[] arr; // N개의 수를 저장할 배열
    private static int[] arr2; // M개의 수를 저장할 배열
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 출력하기 위해 정렬
        Arrays.sort(arr);

        dfs(0, 0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int n, int depth){
        if(depth == M){
            for(int val : arr2){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        /*
            같은 수를 여러 번 골라야 하기 때문에
            재귀 호출을 할때 for 문 안에 변수인 i 값을 넘겨주면 된다. 
         */
        for(int i=0; i<N; i++){
            arr2[depth] = arr[i];
            dfs(i, depth+1);
        }
    }

}

