import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 6603번 - 로또 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 07 - 07
*    메모리 : 14320 KB
*    시간 : 140 ms
 */

public class Main {
    private static int K;
    private static int[] arr; // K개의 수가 들어갈 배열
    private static int[] tArr; // K개의 수 중에서 6개를 뽑아 저장할 배열
    private static boolean[] visited; // 방문 표시
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0) break;

            arr = new int[K];
            visited = new boolean[K];
            tArr = new int[6];

            for(int i=0; i<K; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb = new StringBuilder();

            dfs(0,0);

            bw.write(sb.toString());
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int n,int depth){
        // 로또 번호 6개를 뽑았으면 StringBuilder 에 배열을 저장
        if(depth == 6){
            for(int val : tArr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 재귀 호출로 로또 번호 6개를 선택
        for(int i=n; i<K; i++){
            visited[i] = true;
            tArr[depth] = arr[i];
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }

}

