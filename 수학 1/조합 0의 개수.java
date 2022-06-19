import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 2004번 - 조합 0의 개수 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 19
*    메모리 : 14234 KB
*    시간 : 128 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long count5 = five(N) - five(N-M) - five(M);
        long count2 = two(N) - two(N-M) - two(M);

        bw.write(Math.min(count2, count5)+"");

        bw.flush();
        bw.close();
        br.close();
    }
    // 5의 승수
    public static long five(long num) {
        int count = 0;

        while(num >= 5) {
            count += num/5;
            num /= 5;
        }
        return count;
    }
    // 2의 승수
    public static long two(long num) {
        int count = 0;

        while(num >= 2) {
            count += num/2;
            num /= 2;
        }
        return count;
    }
}
/*
  일단 조합 공식이 잘 기억나질 않아 찾아봤다.
  n! / (n-r)! r!인 것을 알았지만 이 공식을 그대로 코드에 사용하면 시간초과가 날 것이 분명했다.

  그래서 참고를 했는데, 조합의 성질을 이용한 문제인 것 같다.

  "팩토리얼 0의 개수"를 구하는 것처럼 조합 또한 규칙이 존재하는데, 그게 2와 5의 개수이다.
  조합의 값 끝자리 0의 개수를 구하기 위해 10(2*5)을 얼마나 많이 가지고 있는지 알면 된다.
  그래서 2와 5의 배수를 구하면 되기 때문에 위와 같이 two와 five 메서드로 개수를 센다.

  그리고 2와 5 각각 n!에서 (n-r)!와 m!를 빼준 값 중에 최솟값을 결과로 한다.

  이런 문제들을 쉽게 생각하고 해결하기에는 나에겐 수학적 머리가 부족한 것 같다. 

 */
