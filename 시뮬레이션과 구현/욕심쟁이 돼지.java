import java.io.*;
import java.util.*;

/*   Baekjoon 3060번 - 욕심쟁이 돼지 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 26
*    메모리 : 14848 KB
*    시간 : 152 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t=0; t<T; t++){
            long N = Integer.parseInt(br.readLine()); // 사료의 양

            long[] arr = new long[6]; // 6마리의 돼지가 첫 날에 먹었던 식사의 양

            int day = 1;
            long val = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<6; i++){
                arr[i] = Long.parseLong(st.nextToken());
                val += arr[i];
            }

            // 하루가 지날 때마다 돼지들이 먹는 사료의 양이 4배씩 증가한다.
            while(val <= N){
                val *= 4;
                day++;
            }

            bw.write(day+"\n");

        }
        bw.flush();

        bw.close();
        br.close();
    }
}

