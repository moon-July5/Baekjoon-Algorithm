import java.io.*;
import java.util.StringTokenizer;


/*   Baekjoon 2609번 - 최대공약수와 최소공배수 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 18
*    메모리 : 16084 KB
*    시간 : 156 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        /*
            최소공배수는 두 정수를 곱한 후 최대공약수로 나눈 값이다.
            (a*b) / gcd
         */
        bw.write(gcd(a,b)+"\n"+(a*b)/gcd(a,b));
        bw.flush();
        bw.close();
        br.close();
    }

    // "유클리드 호제법"으로 최대공약수를 구하는 메서드
    // 최대공약수를 구하기 위해 두 정수를 나눈 나머지를 이용한다.
    // ex) 두 정수 a와 b 각각 24,18를 -> 18,6 -> 6,0 이런식으로 반복하여 b가 0이되면 a 값이 최대공약수가 된다.
    public static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
