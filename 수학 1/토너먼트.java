import java.io.*;
import java.util.StringTokenizer;


/*   Baekjoon 1057번 - 토너먼트 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 10
*    메모리 : 14384 KB
*    시간 : 124 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 참가자의 수
        int jimin = Integer.parseInt(st.nextToken()); // 지민이의 번호
        int hansoo = Integer.parseInt(st.nextToken()); // 한수의 번호

        int answer = 0;

        // 수학적인 접근으로 해결해야 함
        while (jimin != hansoo){
            jimin = jimin/2 + jimin%2;
            hansoo = hansoo/2 + hansoo%2;
            answer++;
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }
}



