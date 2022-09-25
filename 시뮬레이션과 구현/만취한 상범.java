import java.io.*;

/*   Baekjoon 6359번 - 만취한 상범 (Bronze Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 25
*    메모리 : 14420 KB
*    시간 : 136 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine()); // 방의 개수

            boolean[] door = new boolean[N+1]; // 문이 열렸는지 잠겨있는지 확인

            for(int i=1; i<=N; i++){ // 1부터 N 까지의 라운드
                for(int j=0; j<=N; j+=i){ // 1부터 N 까지 방
                    if(j!=0) door[j] = !door[j]; // 문이 열려있으면 잠그고, 닫혀있으면 연다.
                }
            }

            int answer = 0;

            // 문이 열렸는지 확인하고 개수 계산 (true일 경우, 열림)
            for(int i=1; i<=N; i++){
                if(door[i]) answer++;
            }

            bw.write(answer+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



