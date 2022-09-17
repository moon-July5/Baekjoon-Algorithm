import java.io.*;
import java.util.Arrays;


/*   Baekjoon 2217번 - 로프 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 17
*    메모리 : 26676 KB
*    시간 : 340 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        int max = Integer.MIN_VALUE; // 버틸 수 있는 중량 최댓값

        // 버틸 수 있는 중량 무게
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순으로 정렬하여 무게가 낮은 순부터 탐색
        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            max = Math.max(max, arr[i] * (N - i));
        }

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



