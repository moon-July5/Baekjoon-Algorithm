import java.io.*;
import java.util.*;

/*   Baekjoon 11478번 - 서로 다른 부분 문자열의 개수 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 22
*    메모리 : 227128 KB
*    시간 : 744 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        HashSet<String> hashSet = new HashSet<>(); // 중복을 제거하기 위함
        
        // 문자열의 길이만큼 반복하며, 문자열의 한 글자씩 확인
        for(int i=0; i<s.length(); i++){
            // j의 값을 증가시키면서 문자열을 한 글자, 두 글자, 세 글자,... 씩 분할한다.
            for(int j=i; j<s.length(); j++){
                // 분할된 문자열을 HashSet에 저장하여 중복을 제거한다.
                hashSet.add(s.substring(i, j+1));
            }
        }

        bw.write(hashSet.size()+"");
        bw.flush();

        bw.close();
        br.close();
    }
}


