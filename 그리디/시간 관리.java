import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 1263번 - 시간 관리 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 24
*    메모리 : 14720 KB
*    시간 : 144 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 일의 수

        int[][] arr = new int[N][2];

        // 일을 처리하는 데 걸리는 시간과 일 마감 시간 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 일을 처리하는 데 걸리는 시간
            int s = Integer.parseInt(st.nextToken()); // 일 마감 시간

            arr[i][0] = t;
            arr[i][1] = s;
        }

        // 일 마감 시간 기준으로 내림차순으로 정렬
        Arrays.sort(arr, (a1, a2) -> a2[1] - a1[1]);

        int answer = arr[0][1] - arr[0][0];

        for(int i=1; i<N; i++){
            if(arr[i][1] < answer){
                answer = arr[i][1];
            }
            answer -= arr[i][0];
        }

        if(answer<0) bw.write(-1+"");
        else bw.write(answer+"");

        bw.flush();

        bw.close();
        br.close();
    }
}



