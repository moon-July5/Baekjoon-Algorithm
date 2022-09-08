import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1051번 - 숫자 정사각형 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 08
*    메모리 : 30180 KB
*    시간 : 268 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 직사각형 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M][N];

        // 직사각형 각 칸의 숫자 입력
        for(int i=0; i<M; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        // 정사각형의 크기를 구하기 위해, 최대 길이는 세로와 가로 크기 중 최소 크기가 된다.
        int len = Math.min(M, N);

        while(len > 1){
            // (세로와 가로 크기 - len) 까지만 반복. 그 이상은 직사각형 크기를 벗어난다.
            for(int i=0; i<=M-len; i++){
                for(int j=0; j<=N-len; j++){
                    int val = arr[i][j];

                    // 각각 우측 상단, 좌측 하단, 우측 하단에 있는 값이 같을 경우 정사각형의 크기 반환
                    // 처음부터 정사각형 크기가 큰 경우부터 하기 때문에 정사각형의 크기를 반환 후 종료하도록 한다.
                    if(val==arr[i][j+len-1] && val==arr[i+len-1][j] && val==arr[i+len-1][j+len-1]){
                        System.out.println(len*len);
                        return;
                    }
                }
            }
            len--; // 정사각형의 크기를 점점 줄인다.
        }

        // 만약 위의 for문에서 탐색하지 못했을 경우 크기 반환
        bw.write(len*len+"");

        bw.close();
        br.close();
    }
}



