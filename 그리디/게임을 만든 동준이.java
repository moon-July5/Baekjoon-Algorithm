import java.io.*;

/*   Baekjoon 2847번 - 게임을 만든 동준이 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 18
*    메모리 : 14260 KB
*    시간 : 124 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 레벨의 수

        int[] arr = new int[N];

        // 각 레벨을 클리어하면 얻는 점수 입력
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;

        // 마지막 레벨부터 비교
        for(int i=N-1; i>=1; i--){
            // 만약 더 어려운 레벨의 점수가 높다면 점수를 감소시킬 필요가 없다. 
            if(arr[i]>arr[i-1]) continue;

            // 두 레벨의 차를 절댓값으로 구하고 +1을 한다. 
            // +1을 하는 이유는 두 레벨의 차를 절댓값으로만 구하면 두 레벨의 점수는 같기 때문에 더 감소시켜야 하기 때문이다.
            int value = Math.abs(arr[i] - arr[i-1]) + 1;

            // 감소시켜야하는 점수를 누적해서 더한다.
            answer += value;
            // 다음 탐색에서 이전 레벨과 비교하기 위해 감소시킨다.
            arr[i-1] -= value;
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



