import java.io.*;

/*   Baekjoon 17615번 - 볼 모으기 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 24
*    메모리 : 19944 KB
*    시간 : 272 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 볼의 총 개수
        String ball = br.readLine(); // 볼의 색깔을 나타내는 문자열(R-빨강, B-파랑)

        int rCnt = 0, bCnt=0;

        // 빨강과 파랑의 개수를 계산
        for(int i=0; i<ball.length(); i++){
            if(ball.charAt(i)=='R') rCnt++;
            else bCnt++;
        }

        int answer = N; // 초기값

        int count = 0;
        // 모든 빨간공을 왼쪽으로 옮길 경우, 왼쪽에서부터 연속된 빨간공의 개수 탐색
        for(int i=0; i<ball.length(); i++){
            if(ball.charAt(i)=='R') count++;
            else break;
        }

        // 모든 빨간공을 왼쪽으로 옮기는 경우, 옮긴 횟수는 (전체 빨간공의 개수 - 처음부터 연속해서 나타나는 빨간공의 개수) 이다.
        answer = Math.min(answer, rCnt - count);

        count = 0;
        // 모든 파란공을 왼쪽으로 옮길 경우, 왼쪽에서부터 연속된 파란공의 개수 탐색
        for(int i=0; i<ball.length(); i++){
            if(ball.charAt(i)=='B') count++;
            else break;
        }

        // 모든 파란공을 왼쪽으로 옮기는 경우, 옮긴 횟수는 (전체 파란공의 개수 - 처음부터 연속해서 나타나는 파란공의 개수) 이다.
        answer = Math.min(answer, bCnt - count);

        count = 0;
        // 모든 빨간공을 오른쪽으로 옮기는 경우, 오른쪽에서부터 연속된 빨간공의 개수 탐색
        for(int i=N-1; i>=0; i--){
            if(ball.charAt(i)=='R') count++;
            else break;
        }

        answer = Math.min(answer, rCnt - count);

        count = 0;
        // 모든 파란공을 오른쪽으로 옮길 경우, 오른쪽에서부터 연속된 파란공의 개수 탐색
        for(int i=N-1; i>=0; i--){
            if(ball.charAt(i)=='B') count++;
            else break;
        }

        answer = Math.min(answer, bCnt - count);

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



