import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


/*   Baekjoon 9375번 - 패션왕 신해빈 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 31
*    메모리 : 14552 KB
*    시간 : 144 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine()); // 해빈이가 가진 의상 수

            HashMap<String, Integer> hashMap = new HashMap<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()); // (의상의 이름, 종류)
                st.nextToken(); // 의상의 이름은 버림

                String kind = st.nextToken();

                hashMap.put(kind, hashMap.getOrDefault(kind, 0)+1); // 의상 종류의 개수를 계산

            }

            int answer = 1;

            // 안 입는 경우를 고려하여 각 종류별 옷의 개수 +1 해준 값을 곱해준다.
            for(int val : hashMap.values()){
                answer *= (val + 1);
            }

            // 경우의 수 중에 옷을 하나도 입지 않은 경우도 있기 때문에 -1을 한다.
            bw.write(answer-1+"\n");

        }
        bw.flush();

        bw.close();
        br.close();
    }
}



