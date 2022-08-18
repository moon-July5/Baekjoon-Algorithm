import java.io.*;
import java.util.*;


/*   Baekjoon 1302번 - 베스트셀러 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 08 - 18
*    메모리 : 14264 KB
*    시간 : 124 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 하루 동안 팔린 책의 개수

        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        int max = 0;

        for(int i=0; i<N; i++){
            String s = br.readLine(); // 팔린 책의 이름

            map.put(s, map.getOrDefault(s, 0)+1); // 같은 이름의 책이 나올때마다 +1 추가
            max = Math.max(max, map.get(s)); // 가장 많이 팔린 책의 개수 갱신
        }

        // 가장 많인 팔린 책을 list에 저장
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()==max) list.add(entry.getKey());
        }

        // 사전순으로 정렬
        Collections.sort(list);

        // 가장 많이 팔린 책 이름 출력
        bw.write(list.get(0));

        bw.close();
        br.close();
    }
}


