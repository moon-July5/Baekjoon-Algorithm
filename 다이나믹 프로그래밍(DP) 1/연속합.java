import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1912번 - 연속합 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 22
*    메모리 : 22952 KB
*    시간 : 280 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // N개의 정수

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        int sum = 0; // 연속된 수들의 합
        int max = arr[0]; // 초기 최대 값

        for(int i=0; i<N; i++){
            // 계속 연속된 정수들을 더한다.
            sum += arr[i];
            // 더하고 이전까지의 최대값하고 비교
            max = Math.max(max, sum);
            
            // 만약 음수를 더하여 0보다 작아졌을 때, 연속된 수들의 합을 초기화
            if(sum < 0)
                sum = 0;
        }

        bw.write(max + "");
        bw.flush();

        bw.close();
        br.close();
    }


}

