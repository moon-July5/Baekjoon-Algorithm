import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 16112번 - 5차 전직 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 22
*    메모리 : 58916 KB
*    시간 : 832 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 퀘스트의 개수
        int K = Integer.parseInt(st.nextToken()); // 동시에 활성화할 수 있는 아케인스톤의 개수

        long[] arr = new long[N];

        // 퀘스트 경험치 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Long.parseLong(st.nextToken());

        // 오름차순으로 정렬
        Arrays.sort(arr);

        int count = 0; // 최대 아케인스톤 할성화 개수
        long answer = 0; // 최대 경험치의 합

        for(int i=0; i<N; i++){
            if(count < K){ // 동시에 아케인스톤을 활성화할 수 있다면
                count++;

                answer -= arr[i];
            }

            answer += (arr[i] * count); // 활성화된 아케인스톤의 개수와 경험치를 곱한다.
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



