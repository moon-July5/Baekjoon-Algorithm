import java.io.*;
import java.util.StringTokenizer;


/*   Baekjoon 6159번 - 코스튬 파티 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 10 - 13
*    메모리 : 18420 KB
*    시간 : 896 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 소의 수
        int S = Integer.parseInt(st.nextToken()); // 코스튬의 크기

        int answer = 0; // 코스튬에 얼마나 많은 서로 다른 소의 짝의 개수

        int[] arr = new int[N];

        // 소들의 크기 입력
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i=0; i<N-1; i++){
            for(int j=i; j<N; j++){
                if(i==j) continue;
                // 서로 다른 두 소의 크기를 더한 값이 코스튬의 크기보다 작거나 같다면 count
                if(arr[i]+arr[j] <= S) answer++;
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



