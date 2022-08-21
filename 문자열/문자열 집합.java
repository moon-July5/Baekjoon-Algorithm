import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*   Baekjoon 14425번 - 문자열 집합 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 20
*    메모리 : 31644 KB
*    시간 : 412 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집합 S에 포함된 문자열의 개수
        int M = Integer.parseInt(st.nextToken()); // 검사해야 하는 문자열의 개수

        HashMap<String, Integer> hashMap = new HashMap<>(); // 집합 S에 포함된 문자열 저장

        for(int i=0; i<N; i++){
            hashMap.put(br.readLine(), 0);
        }

        int answer = 0;

        for(int i=0; i<M; i++){
            // 검사해야하는 문자열이 집합 S에 포함되어있다면 count
            if(hashMap.containsKey(br.readLine())) answer++;
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }
}


