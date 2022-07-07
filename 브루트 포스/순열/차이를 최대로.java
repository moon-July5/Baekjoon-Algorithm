import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 10819번 - 차이를 최대로 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 07 - 07
*    메모리 : 15436 KB
*    시간 : 156 ms
 */

public class Main {
    private static int N;
    private static int[] arr; // 초기 입력 값
    private static int[] tArr; // arr 의 순서를 바꾸기 위한 배열
    private static boolean[] visited; // 방문 표시
    private static int max = Integer.MIN_VALUE; // 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tArr = new int[N];
        visited = new boolean[N];

        // 정수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(0);

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // 배열의 순서를 바꾸면서 식의 최댓값 구하는 메서드
    public static void dfs(int depth){
        if(depth == N){
            max = Math.max(max, getResult());
            return;
        }

        // 재귀호출을 하여 배열의 순서를 바꾼다.
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                tArr[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    // 배열에 들어있는 정수들의 합을 구하는 메서드
    public static int getResult(){
        int sum = 0;
        for(int i=0; i<N-1; i++){
            sum += Math.abs(tArr[i] - tArr[i+1]);
        }
        return sum;
    }



}

