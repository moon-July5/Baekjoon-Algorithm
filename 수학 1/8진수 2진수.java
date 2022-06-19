import java.io.*;

/*   Baekjoon 1212번 - 8진수 2진수 (Bronze Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 19
*    메모리 : 48900 KB
*    시간 : 476 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();   // 8진수

        for(int i=0; i<s.length(); i++){
            // 한 자릿수마다 2진수로 변환
            String binary = Integer.toBinaryString(s.charAt(i)-'0');

            // 만약 자릿수가 3자리가 안되고 첫 숫자가 아니라면 3자리가 되도록 0으로 채운다.
            if(binary.length()==2 && i!=0) binary="0"+binary;
            else if(binary.length()==1 && i!=0) binary="00"+binary;

            bw.write(binary+"");
        }

        bw.flush();

        bw.close();
        br.close();
    }


}

