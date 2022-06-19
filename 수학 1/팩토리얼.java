import java.io.*;

/*   Baekjoon 10872번 - 팩토리얼 (Bronze Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 19
*    메모리 : 14240 KB
*    시간 : 128 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(factorial(N)+"");

        bw.flush();
        bw.close();
        br.close();
    }
    // 팩토리얼을 구하는 메서드
    public static int factorial(int n){
        if(n<2) return 1;
        // 재귀함수로 값을 추출
        else return n * factorial(n-1);
    }
}
