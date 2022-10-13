import java.io.*;
import java.util.Arrays;

/*   Baekjoon 1337번 - 올바른 배열 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 10 - 13
*    메모리 : 14324 KB
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 배열의 크기

        int[] arr = new int[100];

        // 배열 입력
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        // 배열을 오름차순으로 정렬(입력받은 배열만 정렬)
        Arrays.sort(arr, 0, N);

        int answer = 1;

        for(int i=0; i<N; i++){
            int count = 1;

            // 5개가 연속되는지 확인
            for(int j=i+1; j<i+5; j++){
                if(arr[j]-arr[i]<5 && arr[j]-arr[i]>0) count++;
            }

            answer = Math.max(answer, count);
        }

        // 5이상이면 연속되는 것이 이미 5개 이상이기 때문에 0 출력
        if(answer>=5) bw.write(0+"");
        // 5미만이면 5 - answer 값 출력
        else bw.write(5-answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



