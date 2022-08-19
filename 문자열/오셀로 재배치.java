import java.io.*;

/*   Baekjoon 13413번 - 오셀로 재배치 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 08 - 19
*    메모리 : 56028 KB
*    시간 : 436 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine()); // 오셀로 말의 개수

            String input = br.readLine(); // 오셀로 말의 초기 상태
            String target = br.readLine(); // 오셀로 말의 목표 상태

            int wCount = 0, bCount=0; // W의 개수, B의 개수

            for(int i=0; i<N; i++){
                // 초기 상태와 목표 상태를 비교하여 각 말의 상태가 다르면
                if(input.charAt(i) != target.charAt(i)){
                    if(input.charAt(i) == 'W') wCount++;
                    else bCount++;
                }
            }

            bw.write(Math.max(wCount, bCount)+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}


