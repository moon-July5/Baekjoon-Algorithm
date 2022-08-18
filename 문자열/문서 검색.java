import java.io.*;
import java.util.*;


/*   Baekjoon 1543번 - 문서 검색 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 08 - 18
*    메모리 : 14284 KB
*    시간 : 128 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String doc = br.readLine(); // 문서
        String search = br.readLine(); // 검색하려고 하는 단어

        int count = 0;

        for(int i=0; i<=doc.length() - search.length(); i++){
            boolean flag = true;

            // 문서에서 검색하려고 하는 단어 비교
            for(int j=0; j<search.length(); j++){
                // 한 글자씩 비교하면서 같지 않으면 break
                if(search.charAt(j) != doc.charAt(i+j)){
                    flag = false;
                    break;
                }
            }

            // 만약 문서에서 검색하려고 하는 단어와 똑같다면
            if(flag){
                count++; // count
                i += search.length()-1; // 문서에서 다음 단어부터 비교
            }
        }

        bw.write(count+"");

        bw.close();
        br.close();
    }
}


