import java.io.*;

/*   Baekjoon 1904번 - 01타일 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 16
*    메모리 : 14332 KB
*    시간 : 140 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 자연수 N

        bw.write(Tile(N)+"");
        bw.flush();

        bw.close();
        br.close();
    }
    public static int Tile(int a) {

        if (a == 1) {
            return 1;
        }

        if (a == 2) {
            return 2;
        }

        // 초기 값
        int val1 = 1;
        int val2 = 2;
        int sum = 0;

        for (int i = 2; i < a; i++) {
            sum = (val2 + val1) % 15746;	// 이전 값과 이전의 이전 값의 합
            val1 = val2;	// 이전의 이전 값은 이전 값으로 변경
            val2 = sum;		// 이전 값은 현재 합 값으로 변경
        }

        return sum;
    }
}

