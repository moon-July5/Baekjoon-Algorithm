import java.io.*;
import java.util.ArrayList;

/*   Baekjoon 2872번 - 우리집엔 도서관이 있어 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 21
*    메모리 : 40080 KB
*    시간 : 340 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 책의 개수

        ArrayList<Integer> list = new ArrayList<>();

        // 책 순서 입력
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        int target = N;

        // 가장 아래 번호부터 탐색.
        // 가장 큰 번호가 있는 경우 옮길 필요가 없다.
        for(int i=N-1; i>=0; i--){
            if(list.get(i) == target) target--;
            else answer++;
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



