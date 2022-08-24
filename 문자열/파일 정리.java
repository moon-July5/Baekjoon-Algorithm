import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/*   Baekjoon 20291번 - 파일 정리 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 24
*    메모리 : 49952 KB
*    시간 : 852 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 바탕화면에 있는 파일의 개수

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int n=0; n<N; n++){
            String fileName = br.readLine(); // 파일 이름 입력

            String ext = fileName.substring(fileName.indexOf(".")+1); // 확장자 추출

            hashMap.put(ext, hashMap.getOrDefault(ext, 0)+1); // (확장자명, 개수) 형태로 저장
        }

        ArrayList<String> list = new ArrayList<>(hashMap.keySet());
        // 사전 순으로 정렬
        list.sort((s1, s2) -> s1.compareTo(s2));

        // 정렬된 리스트를 출력
        for(String key : list)
            bw.write(key +" "+hashMap.get(key)+"\n");

        bw.flush();

        bw.close();
        br.close();
    }

}


