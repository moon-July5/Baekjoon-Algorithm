import java.io.*;
import java.util.*;

/*   Baekjoon 1052번 - 물병 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 04
*    메모리 : 16452 KB
*    시간 : 456 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물병의 개수
        int K = Integer.parseInt(st.nextToken()); // 옮길 물병의 개수

        int count = 0;
        int buy = 0;

        if(N <= K) {
            bw.write(0+"");
            bw.flush();
            return;
        }

        while(true){
            count = 0;
            int copyN = N;

            while(copyN != 0){
                // 물병이 홀 수 개이면 count 추가
                if(copyN % 2 == 1) count += 1;
                // 물병의 개수를 2로 나눈다. (물병 합치기)
                copyN /= 2;
            }

            // K개를 넘지 않는 물병을 만들기 위해 종료
            if(count <= K) break;

            N += 1; // 개수 추가
            buy += 1; // 상점에서 물병 구매
        }

        bw.write(buy+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

