import java.io.*;
import java.util.*;

/*   Baekjoon 1769번 - 3의 배수 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 16
*    메모리 : 47620 KB
*    시간 : 304 ms
 */

public class Main {
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine(); // 큰 자연수

        convert(s);

        br.close();
    }

    public static void convert(String s) {
        int sum = 0;

        if (s.length() == 1) { // 숫자의 길이가 1이면
            System.out.println(count); // count 출력
            if (Integer.parseInt(s) % 3 == 0) System.out.println("YES"); // 3의 배수면
            else System.out.println("NO"); // 3의 배수가 아니면

            return;
        } else { // 숫자의 길이가 2 이상이면
            // 숫자의 한 자리씩 모두 더한다.
            for (int i = 0; i < s.length(); i++) {
                int val = Integer.parseInt(String.valueOf(s.charAt(i)));

                sum += val;
            }

            count++;
            convert(Integer.toString(sum));
        }
    }
}


