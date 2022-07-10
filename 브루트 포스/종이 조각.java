import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 14391번 - 종이 조각 (Gold Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 10
*    메모리 : 19344 KB
*    시간 : 172 ms
 */

public class Main {
    private static int N, M; // 종이의 세로, 가로 크기
    private static boolean[][] visited; // 방문 표시
    private static int[][] arr;
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        dfs(0, 0);

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int row, int col){
        // 탐색 종료
        if(row >= N){
            calc();
            return;
        }
        // 1개의 행 확인, 다음 행으로 이동
        if(col >= M){
            dfs(row+1, 0);
            return;
        }

        // 가로 숫자
        visited[row][col] = true;
        dfs(row, col+1);

        // 세로 숫자
        visited[row][col] = false;
        dfs(row, col+1);
    }


    public static void calc() {
        int sum = 0;
        int temp = 0;

        // 가로 계산
        for(int i=0; i<N; i++){
            temp = 0;
            for(int j=0; j<M; j++){
                if(visited[i][j]){ // true 인 경우
                    temp *= 10; // 자릿수 이동
                    temp += arr[i][j];
                } else {
                    sum += temp;
                    temp = 0;   // 변수 초기화
                }
            }
            sum += temp;
        }

        // 세로 계산
        for(int i=0; i<M; i++){
            temp = 0;
            for(int j=0; j<N; j++){
                if(!visited[j][i]){ // false 인 경우
                    temp *= 10; // 자릿수 이동
                    temp += arr[j][i];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }
        max = Math.max(max, sum);
    }
}

