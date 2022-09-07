import java.io.*;

/*   Baekjoon 2851번 - 슈퍼 마리오 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 07
*    메모리 : 14252 KB
*    시간 : 124 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int diff = Integer.MAX_VALUE; // 100에 가까운 점수를 찾기 위해 (100 - 점수)의 차이를 저장
        int sum = 0; // 마리오가 받는 점수의 합
        int answer = 0;

        for(int i=0; i<10; i++){
            int num = Integer.parseInt(br.readLine()); // 버섯의 점수

            sum += num;

            /*
                일단 100에 가까운 점수를 찾아야한다.
                (100 - 점수 합)의 절댓값 한 값의 차이가 최소여야 하며, 만약 가까운 수가 2개이상 이면, 
                그 중 합(sum)이 큰 값을 선택해야 하기 때문에 부등호를 "<="로 해야한다. 
             */
            if(Math.abs(100 - sum) <= diff){
                diff = Math.abs(100 - sum);
                answer = sum;
            }
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }
}



