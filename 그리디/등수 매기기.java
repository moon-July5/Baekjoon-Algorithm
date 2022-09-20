import java.io.*;
import java.util.Arrays;

/*   Baekjoon 2012번 - 등수 매기기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 20
*    메모리 : 56848 KB
*    시간 : 784 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        // 각 사람의 예상 등수 입력
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        // 오름차순으로 정렬
        Arrays.sort(arr);

        long answer = 0;

        for(int i=0,rank=1; i<N; i++,rank++){
            answer += Math.abs(arr[i] - rank); // 오름차순으로 정렬된 상태에서 절댓값(예상 등수 - 실제 등수) 계산한 값을 누적해서 더함
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



