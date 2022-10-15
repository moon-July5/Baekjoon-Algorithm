import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 3273번 - 두 수의 합 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 10 - 15
*    메모리 : 25304 KB
*    시간 : 380 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수열의 크기

        int[] arr = new int[N];

        // 수열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int X = Integer.parseInt(br.readLine());

        // 오름차순 정렬
        Arrays.sort(arr);

        int answer = 0;

        // 시작과 끝 인덱스, 쌍의 합
        int start = 0, end = N-1, sum=0;

        while(start < end){
            // 시작과 끝 인덱스에 있는 값의 합
            sum = arr[start] + arr[end];

            // 만약 그 합이 X와 같다면 count
            if(sum==X) answer++;

            // 합이 X보다 작거나 같다면 시작 인덱스를 +1
            if(sum <= X) start++;
            // 합이 X보다 크다면 끝 인덱스를 -1
            else end--;
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



