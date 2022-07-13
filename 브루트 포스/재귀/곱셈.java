import java.io.*;
import java.util.*;

/*   Baekjoon 1629번 - 곱셉 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 13
*    메모리 : 15844 KB
*    시간 : 152 ms
 */

public class Main {
    private static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bw.write(pow(A, B) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    // mod 연산자의 분배법칙을 이용한 재귀함수
    public static long pow(long a, long b){
        if(b==1) return a % C;

        long answer = pow(a, b/2);

        if(b%2 == 1) return (answer * answer % C) * a % C;

        return answer * answer % C;
    }
}

