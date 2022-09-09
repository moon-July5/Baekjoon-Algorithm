import java.io.*;

/*   Baekjoon 4375번 - 1 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 09
*    메모리 : 14440 KB
*    시간 : 144 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while((input= br.readLine()) != null){
            int N = Integer.parseInt(input);

            int val = 0;

            for(int i=1;;i++){
                val = (val*10) + 1; // 1로만 이루어진 수를 만든다. ex) 1, 11, 111, 1111
                val %= N; // N으로 나누어 떨어지는지 확인
                // % 연산자를 사용하지 않으면 숫자 범위가 넘어갈 수 있다.

                if(val==0){ // 나누어 떨어진다면 i 값을 출력(자릿수를 의미)
                    bw.write(i+"\n");
                    break;
                }
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



