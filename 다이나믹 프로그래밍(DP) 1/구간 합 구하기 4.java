import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11659번 - 구간 합 구하기 4 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 14
*    메모리 : 52796 KB
*    시간 : 692 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        int[] arr = new int[N+1]; // 수들을 저정할 배열

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++)
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken()); // 누적합 더하기

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            // 구간 합 구하기
            bw.write(arr[j] - arr[i-1]+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}


