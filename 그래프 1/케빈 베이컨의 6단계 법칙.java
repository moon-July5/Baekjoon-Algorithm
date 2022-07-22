import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1389번 - 케빈 베이컨의 6단계 법칙 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 22
*    메모리 : 14260 KB
*    시간 : 144 ms
 */

public class Main {
    private static int N, M; // 유저 수, 친구 관계의 수
    private static int[][] arr;
    private static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        // 배열 초기화
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i != j) arr[i][j] = INF;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        // 플로이드 와샬
        for(int k=1; k<=N; k++){ // 거쳐가는 노드
            for(int i=1; i<=N; i++){ // 시작 노드
                for(int j=1; j<=N; j++){ // 도착 노드
                    if(arr[i][k] + arr[k][j] < arr[i][j]){
                        arr[i][j] = arr[i][k] + arr[k][j]; // 최단 거리 값 갱신
                    }
                }
            }
        }

        int n = INF;
        int idx = -1;

        // 케빈 베이컨의 수가 가장 적은 사람 탐색
       for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                sum += arr[i][j];
            }

            // 최소 케빈 베이컨의 수 갱신
            if(n > sum){
                n = sum;
                idx = i; // 인덱스 갱신
            }
        }

        bw.write(idx+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

