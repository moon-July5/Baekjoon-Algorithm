import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*   Baekjoon 1758번 - 알바생 강호 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 18
*    메모리 : 24932 KB
*    시간 : 284 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 사람의 수

        ArrayList<Integer> list = new ArrayList<>();

        // 각 사람이 주려고 하는 팁 입력
        for(int i=0; i<N; i++)
            list.add(Integer.parseInt(br.readLine()));

        // 각 사람이 주려고 하는 팁이 큰 순서부터 정렬 (내림차순)
        Collections.sort(list, Collections.reverseOrder());

        long answer = 0;

        // 강호가 받을 수 있는 최대한의 팁 계산
        for(int i=0, rank=1; i<N; i++, rank++){
            int money = list.get(i) - (rank-1); // 각 사람이 주려고 하는 팁 - (등수 - 1)
            if(money < 0) break; // 팁이 음수가 될 경우 종료

            answer += money; // 팁을 누적해서 계산
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



