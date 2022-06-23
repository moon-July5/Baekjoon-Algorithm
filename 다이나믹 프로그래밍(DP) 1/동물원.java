import java.io.*;

/*   Baekjoon 1309번 - 동물원 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 23
*    메모리 : 14608 KB
*    시간 : 132 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 우리의 크기

        int[] dp = new int[N+1];

        /*
            밑에 방법은 문제에서 규칙을 찾아 구현해낸 방법이다.
            N이 1일 때, 방법은 3가지가 존재, 2일 때 7가지가 존재한다.

            여기서 크기 i에서 방법 수를 찾으려고 할 때 규칙은 [i-1]*2 + [i-2]이다.
         */
        for(int i=1; i<N+1; i++){
            if(i==1) dp[i] = 3;
            else if(i==2) dp[i] = 7;
            else{
                dp[i] = (dp[i-1]*2 + dp[i-2]) % 9901;
            }
        }

        /*
           또 다른 방법은 사자를 배치할 수 있는 경우의 수를 3가지로 생각한다.
           1. N번째 줄에 사자가 없을 경우
           2. N번째 줄에 왼쪽에 사자가 있을 경우
           3. N번째 줄에 오른쪽에 사자가 있을 경우

           1번의 경우 - N-1번째 줄에 사자를 왼쪽, 오른쪽, 아예 없는 경우가 가능하다.
           2번의 경우 - N-1번째 줄에 사자가 왼쪽에 배치되어있기 때문에 오른쪽 배치, 사자가 아예 없는 경우가 가능하다.
           3번의 경우 - N-1번째 줄에 사자가 오른쪽에 배치되어있기 떄문에 왼쪽 배치, 사자가 아예 없는 경우가 가능하다.

           dp를 2차원 배열로 선언
           dp[N][3], [N][0] - 사자가 아예 없는 경우, [N][1] - 사자가 왼쪽에 배치, [N][2] - 사자가 오른쪽에 배치

           초기값
           dp[1][0] = 1, dp[1][1] = 1, dp[1][2] = 2

           // 위의 설명을 토대로 경우의 수 찾기
           for(int i=2; i<N+1; i++) {
                dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
                dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
                dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
           }
         */

        bw.write(dp[N]%9901+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

