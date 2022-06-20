import java.io.*;

/*   Baekjoon 2089번 - -2진수 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 20
*    메모리 : 16240 KB
*    시간 : 160 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 10진법 수

        String answer = "";

        // 0이면 0을 출력하도록 한다.
        if(N==0){
            bw.write(N+"");
            bw.flush();
            return;
        }

        // -2진수로 변환하기 위해 -2로 % 연산자로 나머지를 구하면서 변환한다.
        while(N != 0){
            // % 연산자를 통해 -2로 나눈 나머지가 -1일 경우
            // 부호를 제외한 수가 홀수라는 의미
            if(N%-2 == -1){
                // N % -2의 결과가 음수이기 때문에 +2를 하여 양수로 만들어 추가한다.
                answer = (N%-2) + 2 + answer;
                // (N/-2)의 결과가 음수로 나오기 때문에 +1을 하여 양수로 만들어 준다.
                // ex) -13 / -2 = -6이 나오는데 +1을 하게되면 7로 양수가 된다.
                N = (N/-2) + 1;
            } else {
                // 2진수로 변환하듯이 변환하면 된다.
                answer = (N%-2) + answer;
                N /= -2;
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

