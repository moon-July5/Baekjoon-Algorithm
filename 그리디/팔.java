import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1105번 - 팔 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 24
*    메모리 : 14260 KB
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // L보다 크거나 같고 R보다 작거나 같은 자연수 중에서 8이 가장 적게 들어있는 수 중에 8의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();

        int answer = 0;

        if(L.length() == R.length()){ // L과 R의 길이가 같다면
            for(int i=0; i<L.length(); i++){ // 하나씩 비교
                if(L.charAt(i) != R.charAt(i)) break; // L과 R의 각 자릿수가 같지않다면 종료
                else {
                    if(L.charAt(i) == '8') answer++; // 8이면 count
                }
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



