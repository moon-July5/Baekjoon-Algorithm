import java.io.*;
import java.util.*;

/*   Baekjoon 2910번 - 빈도 정렬 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 01
*    메모리 : 16112 KB
*    시간 : 164 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 메시지의 길이
        int C = Integer.parseInt(st.nextToken()); // N개의 숫자는 C보다 작거나 같다.

        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>(); // (숫자, 숫자의 개수) 형태로 저장

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }

        // key 값(숫자) 들을 ArrayList에 저장
        ArrayList<Integer> list = new ArrayList<>(hashMap.keySet());

        // 저장된 key 값들을 value 값을 기준으로 내림차순 정렬
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(hashMap.get(o2), hashMap.get(o1));
            }
        });

        // 빈도정렬된 수열을 출력
        for(int val : list){
            for(int i=0; i<hashMap.get(val); i++){
                bw.write(val+" ");
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



