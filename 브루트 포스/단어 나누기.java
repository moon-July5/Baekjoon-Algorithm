import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*   Baekjoon 1251번 - 단어 나누기 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 09 - 07
*    메모리 : 16908 KB
*    시간 : 184 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); // 단어

        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>(); // 단어 조합 저장

        // 단어를 세 부분으로 쪼개기 위해 브루트포스로 모두 탐색한다.
        for(int i=1; i<str.length()-1; i++){
            for(int j=i+1; j<str.length(); j++){
                String s1 = sb.append(str.substring(0, i)).reverse().toString(); // 단어의 첫 부분 분할하고 앞뒤를 뒤집는다.
                sb.setLength(0); // StringBuilder 초기화

                String s2 = sb.append(str.substring(i, j)).reverse().toString(); // 단어의 중간 부분 분할하고 앞뒤를 뒤집는다.
                sb.setLength(0);

                String s3 = sb.append(str.substring(j)).reverse().toString(); // 단어의 마지막 부분 분할하고 앞뒤를 뒤집는다.
                sb.setLength(0);

                list.add(s1+s2+s3); // 단어를 세 부분으로 분할하고 각각 앞뒤로 뒤집은 문자열들을 합쳐서 리스트에 저장
            }
        }

        // 오름차순으로 정렬
        Collections.sort(list);

        // 사전순으로 가장 앞서는 단어를 출력
        bw.write(list.get(0));

        bw.close();
        br.close();
    }
}



