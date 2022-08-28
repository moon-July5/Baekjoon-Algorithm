import java.io.*;
import java.util.ArrayList;

/*   Baekjoon 2635번 - 수 이어가기 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 28
*    메모리 : 16672 KB
*    시간 : 162 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> answer = new ArrayList<>();
        int max = 0;

        for(int i=N/2; i<=N; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(N);

            int second = i; // 두 번째 수
            temp.add(second);

            int next = N - second; // 다음 수
            while(true){
                if(next < 0) break; // 음수가 되면 종료

                temp.add(next); // 다음 수를 리스트에 저장

                next = temp.get(temp.size()-2) - temp.get(temp.size()-1); // 앞의 앞의 수에서 앞의 수를 뺀다
            }

            // 최대 개수와 리스트 갱신
            if(max < temp.size()){
                max = temp.size();
                answer = temp;
            }
        }

        // 최대 개수 출력
        bw.write(max+"\n");

        // 최대 개수의 수들을 출력
        for(int val : answer){
            bw.write(val +" ");
        }
        bw.flush();

        bw.close();
        br.close();
    }

}


