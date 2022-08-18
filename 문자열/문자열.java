import java.io.*;
import java.util.*;


/*   Baekjoon 1120번 - 문자열 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 08 - 18
*    메모리 : 14312 KB
*    시간 : 136 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int length = s1.length();

        // 문자열 비교
        for(int i=0; i<=s2.length()-s1.length(); i++){
            int diff = 0;

            // s1의 문자열 전체랑 s2의 부분적인 문자열을 비교
            for(int j=0; j<s1.length(); j++){
                if(s1.charAt(j) != s2.charAt(i+j)) diff++;
            }

            length = Math.min(length, diff);
        }

        bw.write(length+"");


        bw.close();
        br.close();
    }

}


