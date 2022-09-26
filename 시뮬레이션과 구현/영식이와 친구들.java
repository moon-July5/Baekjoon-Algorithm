import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1592번 - 영식이와 친구들 (Bronze Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 26
*    메모리 : 14312 KB
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1부터 N까지의 사람 수
        int M = Integer.parseInt(st.nextToken()); // 한 사람이 공을 M번 받으면 게임 끝
        int L = Integer.parseInt(st.nextToken()); // L번째 있는 사람에게 공을 던짐

        int[] arr = new int[N+1];

        arr[1] = 1;
        int idx = 1;

        int answer = 0;

        while(true){
            // 공을 M번 받은 사람이 있으면 종료
            if(arr[idx] == M) break;

            // 공을 받은 개수가 홀수이면
            if(arr[idx]%2 == 1){
                // 현재 위치에서 시계 방향으로 L 번째 있는 사람에게 던진다.
                idx = (idx+L) % N;
            // 공을 받은 개수가 짝수이면
            } else {
                // 현재 위치에서 반시계 방향으로 L 번째 있는 사람에게 던진다.
                idx = (N-(L-idx)) % N;
            }

            // 받는 횟수 계산
            answer++;
            // L 번째 있는 사람으로 이동
            arr[idx]++;
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



