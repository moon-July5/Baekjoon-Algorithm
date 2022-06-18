import java.io.*;
import java.util.StringTokenizer;


/*   Baekjoon 1934번 - 최소공배수 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 18
*    메모리 : 15052 KB
*    시간 : 168 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 최소공배수는 두 정수 a와 b를 곱한 값에 최대공약수로 나눈 값으로 구할 수 있다.
            bw.write(a*b/gcd(a,b)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 유클리드 호제법을 이용한 최대공약수 구하는 메서드
    // 이 최대공약수를 이용하여 최소공배수를 구한다.
    public static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
