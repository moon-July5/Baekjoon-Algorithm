import java.io.*;
import java.util.*;

/*   Baekjoon 1531번 - 투명 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 07 - 28
*    메모리 : 15864 KB
*    시간 : 140 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 불투명한 종이의 개수
        int M = Integer.parseInt(st.nextToken()); // 그림 위에 M개 이하의 종이가 있으면 그림이 보임

        int[][] arr = new int[101][101];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // (x1, y1) (x2, y2) 범위 내에서 arr 배열에 값 저장
            // 겹치는 구역에 값이 증가된 형태로 저장됨
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    arr[i][j] += 1;
                }
            }
        }

        int count = 0;

        // 보이지 않는 그림의 개수를 구함
        for(int i=1; i<101; i++){
            for(int j=1; j<101; j++){
                // M 값 보다 큰 부분만 계산한다.
                if(arr[i][j] > M) count++;
            }
        }

        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }
}

