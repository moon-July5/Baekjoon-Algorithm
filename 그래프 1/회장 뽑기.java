import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 2660번 - 회장 뽑기 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 07 - 22
*    메모리 : 16128 KB
*    시간 : 160 ms
 */

public class Main {
    private static int INF = 987654321;
    private static int N; // 회원 수
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];

        // 배열 초기화
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i!=j) arr[i][j] = INF;
            }
        }

        // 배열 입력
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1) break;

            arr[a-1][b-1] = 1;
            arr[b-1][a-1] = 1;
        }

        // 플로이드 와샬
        for(int k=0; k<N; k++){ // 거쳐가는 노드
            for(int i=0; i<N; i++){ // 시작 노드
                for(int j=0; j<N; j++){ // 도착 노드
                    if(arr[i][k] + arr[k][j] < arr[i][j]){
                        arr[i][j] = arr[i][k] + arr[k][j]; // 최단 거리 값 갱신
                    }
                }
            }
        }

        int min = INF; // 가장 짧은 거리 저장 

        int[] answer = new int[N]; // 각각 정점에서 가장 짧은 거리 저장

        for(int i=0; i<N; i++){
            int n = 0;
            for(int j=0; j<N; j++){
                n = Math.max(n, arr[i][j]);
            }
            answer[i] = n;
            min = Math.min(min, n);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(answer[i] == min){
                count++;
                sb.append((i+1)+" ");
            }
        }
        bw.write(min +" "+count+"\n");
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }


}

