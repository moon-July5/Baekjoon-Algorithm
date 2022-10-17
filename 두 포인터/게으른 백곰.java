import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 10025번 - 게으른 백곰 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 10 - 17
*    메모리 : 41588 KB
*    시간 : 404 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 얼음 양동이의 개수
        int K = Integer.parseInt(st.nextToken()); // 최적의 위치로부터 떨어진 거리

        int[] arr = new int[1000001];

        // 양동이의 얼음 양과 좌표 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken()); // 양동이의 얼음 양
            int x = Integer.parseInt(st.nextToken()); // 양동이의 좌표

            arr[x] = g;
        }

        int window = 0;

        // 초기 위치에서 K 칸까지 양동이의 얼음 양을 연산
        for(int i=0; i<K+1 && i<arr.length; i++) window += arr[i];

        int answer = 0;

        // 슬라이딩 윈도우 알고리즘
        for(int i=0; i<arr.length; i++){
            int low = i - K - 1;
            int high = i + K + 1;

            // 한 칸씩 옆으로 이동하는 방식
            if(low >= 0) window -= arr[low];
            if(high < arr.length) window += arr[high];

            answer = Math.max(answer, window);
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



