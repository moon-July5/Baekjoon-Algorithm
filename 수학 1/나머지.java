import java.io.*;
import java.util.StringTokenizer;


/*   Baekjoon 10430번 - 나머지 (Bronze Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 18
*    메모리 : 16080 KB
*    시간 : 152 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        /*
            이 문제는 모듈러(%) 연산의 분배법칙에 대한 문제이다.
            각 피연산자에 모듈러 연산을 취하고 계산 결과에 대해 다시 모듈러 연산을 취하면 된다.

            이 분배법칙을 사용하는 이유는 계산 결과에 대해 단순히 모듈러 연산을 취하게 되면
            계산 값이 큰 경우 오버플로우가 발생할 수 있다.
            그렇기 때문에 연산 과정 도중에 모듈러 연산을 취하는 분배법칙이 중요하다.
         */

        bw.write((A+B)%C+"\n"); // (A+B) % C
        bw.write(((A%C)+(B%C))%C+"\n"); // ((A%C)+(B%C)) % C
        bw.write((A*B)%C+"\n"); // (A*B) % C
        bw.write(((A%C)*(B%C))%C+"\n"); // ((A%C)*(B%C)) % C
        bw.close();
        br.close();
    }
}
