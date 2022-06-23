import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1932번 - 정수 삼각형 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 23
*    메모리 : 26376 KB
*    시간 : 304 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 정수 삼각형의 크기
        int[][] arr = new int[N][N];

        // 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
            정수 삼각형 맨 밑단에서부터 계산한다.

            맨 밑단에서 현재 위치와 그 다음 위치 중에서 가장 큰 값을 선택하여
            윗 줄에서 인접한 곳과 누적해서 더한다.

            그러면 가장 꼭대기인 arr[0][0]에는 최대 값이 저장되어 있을 것이다. 
         */
        for(int i=N-1; i>0; i--){
            for(int j=0; j<i; j++){
                arr[i-1][j] += Math.max(arr[i][j], arr[i][j+1]);
            }
        }
        bw.write(arr[0][0]+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

