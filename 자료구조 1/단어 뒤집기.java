import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 9093번 - 단어 뒤집기 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 16
*    메모리 : 48320 KB
*    시간 :  532 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수

        for(int i=0; i<T; i++){
            // 문자열을 분할하여 저장
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                String word = st.nextToken();   // 공백을 기준으로 분할된 단어를 추출
                StringBuilder sb = new StringBuilder(word); // 단어를 StringBuilder 객체에 저장

                String sentence = sb.reverse().toString(); // StringBuilder 객체의 reverse() 메서드를 이용
                bw.write(sentence+" "); // 뒤집힌 단어를 출력
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
