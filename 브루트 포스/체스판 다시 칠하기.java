import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1018번 - 체스판 다시 칠하기 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 08
*    메모리 : 14492 KB
*    시간 : 136 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 보드 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] arr = new char[M][N];

        // 보드의 각 행 상태 입력
        for(int i=0; i<M; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int k=0; k<M-7; k++){
            for(int q=0; q<N-7; q++){
                char color = arr[k][q]; // 첫 번째 색
                int count = 0;

                // 8 * 8 크기만큼 탐색
                for(int i=k; i<k+8; i++){
                    for(int j=q; j<q+8; j++){
                        // 올바른 색이 아닐 경우 증가
                        if(color != arr[i][j]) count++;

                        // 다음 칸은 색이 바뀌여야 하기 때문에 색을 변환한다.
                        if(color=='W') color='B';
                        else color='W';
                    }
                    // 다음 행 시작부분 또한 색이 바뀌여야 하기 때문에 변환한다.
                    if(color=='W') color='B';
                    else color='W';
                }

                // 첫 번째 칸의 색 기준으로 색칠 할 개수와 첫 번째 칸의 반대되는 색 기준 중 최솟값 갱신
                count = Math.min(count, 64-count);

                // 이전까지의 경우 중 최솟값 갱신
                answer = Math.min(answer, count);
            }
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }
}



