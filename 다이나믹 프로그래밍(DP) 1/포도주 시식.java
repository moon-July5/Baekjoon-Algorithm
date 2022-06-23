import java.io.*;

/*   Baekjoon 2156번 - 포도주 시식 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 23
*    메모리 : 15400 KB
*    시간 : 152 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 포도주 잔의 개수

        int[] arr = new int[N];
        int[] dp = new int[N];

        // 포도주 양 입력
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        if(N==1) bw.write(arr[0]+""); // 포도주 잔의 개수가 1개 일 때
        else if(N==2) bw.write(arr[0]+arr[1]+""); // 포도주 잔의 개수2개 일 때
        else {
            // 1개 중에 arr[0]이 최대 값
            dp[0] = arr[0];

            // 2개 중에 arr[0]+arr[1]이 최대 값
            dp[1] = arr[0]+arr[1];

            // 3개 중에 두 개를 선택하는 경우 중 최대 값을 선택
            dp[2] = Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));

            for(int i=3; i<N; i++){
                /* i개 중에 3개 연속으로 마실 수 없는 점을 생각해서 경우의 수를 계산한다.
                
                   예를 들어, 3개를 선택해야 하는 경우, 첫 번째와 한 칸 건너뛰어서 
                   세 번째와 네 번째 잔을 선택하는 경우와 첫 번째, 두 번째 잔, 그리고 네 번째 잔을 선택하는 경우
                   중에서 최대 값을 선택한다. 
                */
                dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
                
                /*
                    위에서 최대 값을 구하고 마지막으로 경우의 수를 하나 더 생각한다.
                    3개를 선택하지 않고 두 개를 선택하는 경우 중에서도 구한다.
                 */
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
            bw.write(dp[N-1]+"");
        }

        bw.flush();

        bw.close();
        br.close();
    }


}

