import java.io.*;
import java.util.*;

/*   Baekjoon 10448번 - 유레카 이론 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 06
*    메모리 : 15860 KB
*    시간 : 184 ms
 */

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        // 문제에서 주어진 정수 입력 범위가 1000 이하이기 때문에
        // 1000이 되지 않는 수를 n=45로 도출할 수 있다.
        arr = new int[45];

        // 삼각수의 공식
        for(int i=1; i<45; i++)
            arr[i] = i * (i+1) / 2;

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            int answer = solve(n);

            bw.write(answer+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    private static int solve(int n) {
        // n이 최대 3개의 삼각수 합으로 표현할 수 있는 확인
        for(int i=1; i<45; i++){
            for(int j=1; j<45; j++){
                for(int k=1; k<45; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == n)
                        return 1;
                }
            }
        }

        return 0;
    }
}



