import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 15658번 - 연산자 끼워넣기 (2) (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 13
*    메모리 : 19844 KB
*    시간 : 180 ms
 */

public class Main {
    private static int N; // 수의 개수
    private static int[] arr; // 수 저장 공간
    private static int[] op; // 사칙연산의 개수 저장 공간
    private static int max = Integer.MIN_VALUE; // 최댓값
    private static int min = Integer.MAX_VALUE; // 최솟값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        op = new int[4];

        // N개의 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 사칙연산 개수 입력(덧셈, 뺄셈, 곱셈, 나눗셈)
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, arr[0]);

        bw.write(max+"\n"+min);
        bw.flush();

        bw.close();
        br.close();
    }

    public static void solve(int depth, int sum){
        if(depth == N){ // N개의 수를 모두 탐색했으면
            max = Math.max(max, sum); // 최댓값 갱신
            min = Math.min(min, sum); // 최솟값 갱신
            return;
        }

        // 사칙연산 탐색
        for(int i=0; i<4; i++){
            if(op[i]==0) continue; // 연산의 개수가 0개이면 다른 연산으로 탐색

            op[i]--; // 연산의 개수 감소

            if(i==0) solve(depth+1, sum + arr[depth]); // 덧셈
            else if(i==1) solve(depth+1, sum - arr[depth]); // 뺄셈
            else if(i==2) solve(depth+1, sum * arr[depth]); // 곱셈
            else if(i==3) solve(depth+1, sum / arr[depth]); // 나눗셈

            op[i]++; // 연산의 개수 증가
        }
    }
}



