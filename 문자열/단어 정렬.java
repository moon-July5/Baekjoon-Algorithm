import java.io.*;
import java.util.*;


/*   Baekjoon 1181번 - 단어 정렬 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 16
*    메모리 : 24092 KB
*    시간 : 1628 ms
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수

        ArrayList<String> list = new ArrayList<>();

        // 단어 입력
        for(int i=0; i<N; i++){
            String s = br.readLine();

            // 중복 제거
            if(!list.contains(s))
                list.add(s);
        }

        // 문자열 정렬
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 문자열의 길이가 같으면
                if(o1.length() == o2.length())
                    // 사전순으로 정렬
                    return o1.compareTo(o2);

                // 문자열의 길이가 짧은 순대로 정렬
                return o1.length() - o2.length();
            }
        });

        for(String s : list)
            bw.write(s+"\n");
        bw.flush();


        bw.close();
        br.close();
    }
}


