import java.io.*;

/*   Baekjoon 11729번 - 하노이 탑 이동 순서 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 13
*    메모리 : 37052 KB
*    시간 : 432 ms
 */

public class Main {
    private static int N;   // 원판의 개수
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int count = (int) Math.pow(2, N) - 1;
        bw.write(count+"\n");

        hanoi(N, 1, 2, 3);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void hanoi(int num, int one, int two, int three){
        if(num==0) return;
        else {
            hanoi(num-1, one, three, two);
            sb.append(one).append(' ').append(three).append('\n');
            hanoi(num-1, two, one, three);
        }
    }
}

