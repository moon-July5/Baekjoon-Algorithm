import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1149번 - RGB 거리 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 22
*    메모리 : 14648 KB
*    시간 : 144 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 집의 수
        int[][] rgb = new int[N][3];    // 0: red, 1:green, 2:blue

        // 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*  모든 집을 칠하는 비용의 최솟값 구하기
            먼저, 첫 번째 집의 다음 집부터 각각 최소 비용을 구한다.

            예를 들어, 만약 두 번째 집의 색을 선택한다고 가정했을 때, 그 앞 집에서는 똑같은 색을 칠할 수 없기 때문에
            똑같은 색을 제외한 모든 색 중에서 최소 비용을 구하고 누적해서 더한다.

            이런식으로 그 앞 집에서 빨강일 경우, 초록일 경우, 파랑일 경우를 생각해서 최소 비용만 찾아서 더한다.
        */
        for(int i=1; i<N; i++){
            rgb[i][0] += Math.min(rgb[i-1][1], rgb[i-1][2]);
            rgb[i][1] += Math.min(rgb[i-1][0], rgb[i-1][2]);
            rgb[i][2] += Math.min(rgb[i-1][0], rgb[i-1][1]);
        }

        bw.write(Math.min(rgb[N-1][0],Math.min(rgb[N-1][1],rgb[N-1][2]))+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

