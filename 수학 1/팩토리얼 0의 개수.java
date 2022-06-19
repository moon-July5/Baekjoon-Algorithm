import java.io.*;

/*   Baekjoon 1676번 - 팩토리얼 0의 개수 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 19
*    메모리 : 14324 KB
*    시간 : 128 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        // N이 5의 배수마다 0의 개수가 변한다.
        // 반복문을 통해 5로 나누면서 누적합을 해줘야 한다.
        while(N >= 5){
            count += N/5;
            N /=5;
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
