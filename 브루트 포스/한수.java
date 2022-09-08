import java.io.*;

/*   Baekjoon 1065번 - 한수 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 08
*    메모리 : 14284 KB
*    시간 : 124 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        // 1 ~ 99는 모두 등차수열이기 때문에 100보다 작은 수를 입력받는다면 N을 출력하면 된다.
        if(N < 100) answer = N;
        // 100보다 크다면
        else {
            answer = 99; // 최소한의 개수는 99부터 시작한다.

            for(int i=100; i<=N; i++){
                int n1 = i % 10; // 일의 자리
                int n2 = (i/10) % 10; // 십의 자리
                int n3 = i / 100; // 백의 자리

                // 각 자릿수가 수열을 이룬다면
                if((n3 - n2) == (n2 - n1)) answer++;
            }
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }
}



