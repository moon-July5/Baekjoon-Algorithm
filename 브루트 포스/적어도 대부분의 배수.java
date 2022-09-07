import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1145번 - 적어도 대부분의 배수 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 07
*    메모리 : 14324 KB
*    시간 : 148 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        int value = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine()); // 5개의 자연수 입력

        // 5개의 자연수를 배열에 저장
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            // 5개의 자연수 중에서 가장 작은 수 탐색
            // 가장 작은 수부터 "적어도 대부분의 배수"를 찾기 위해서다.
            if(arr[i] < value)
                value = arr[i];
        }

        while(true){
            int count = 0; // 배수의 개수 계산

            for(int i=0; i<5; i++){
                // 값이 나누어 떨어지는지 확인
                if(value%arr[i] == 0){
                    // 나누어 떨어진다면 count
                    count++;
                }
            }

            // 적어도 3개로 나누어졌다면 "적어도 대부분의 배수"가 성립
            if(count >= 3) break;

            value++;
        }

        bw.write(value+"");

        bw.close();
        br.close();
    }
}



