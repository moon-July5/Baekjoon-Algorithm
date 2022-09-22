import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 15729번 - 방탈출 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 22
*    메모리 : 71244 KB
*    시간 : 436 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 자리 수

        boolean[] button = new boolean[N+2]; // 버튼을 누른 여부

        // 쪽지에 적혀있는 각 자리 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            // 버튼을 누른 형태라면 true로 저장
            if(num==1) button[i] = true;
        }

        int answer = 0;

        // 쪽지에 적혀있는 각 버튼을 모두 0으로 만든다는 생각으로 접근
        for(int i=0; i<N; i++){
            if(button[i]){ // 쪽지에 각 버튼이 1이라면 (버튼을 누른 형태)
                answer++; // count

                // 1인 버튼 뿐만 아니라 오른쪽 두 개의 버튼 또한 반전시켜 저장한다.
                button[i] = !button[i];
                button[i+1] = !button[i+1];
                button[i+2] = !button[i+2];
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



