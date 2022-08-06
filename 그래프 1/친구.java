import java.io.*;

/*   Baekjoon 1058번 - 친구 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 06
*    메모리 : 14668 KB
*    시간 : 140 ms
 */
public class Main {
    private static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 사람 수

        int[][] arr = new int[N][N];

        // 관계 입력
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                if(i==j) continue;

                if(s.charAt(j)=='Y') arr[i][j] = 1;
                else arr[i][j] = INF;
            }
        }

        // 플로이드 와샬
        for(int k=0; k<N; k++){ // 거쳐가는 지점
            for(int i=0; i<N; i++){ // 시작 지점
                for(int j=0; j<N; j++){ // 도착 지점
                    if(i==j) continue;

                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int max = 0; // 가장 유명한 사람의 친구 수

        for(int i=0; i<N; i++){
            int count = 0;

            for(int j=0; j<N; j++){
                // 2-친구 수를 구해야 하기 때문에 2 이하의 값을 탐색 후 count
                if(arr[i][j] == 1 || arr[i][j] == 2) count++;
            }

            // 가장 유명한 사람의 친구 수를 계산
            max = Math.max(max, count);
        }
        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

