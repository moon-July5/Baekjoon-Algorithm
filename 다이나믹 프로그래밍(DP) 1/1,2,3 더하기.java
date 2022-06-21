import java.io.*;

/*   Baekjoon 9095번 - 1, 2, 3 더하기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 21
*    메모리 : 14612 KB
*    시간 : 140 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n+1];

            for(int i=0; i<n+1; i++){
                if(i <= 2) arr[i] = i;
                else if(i == 3) arr[i] = 4;
                // i의 방법 수를 구하기 위해 i-3의 방법 수 + i-2의 방법 수 + i-1의 방법 수를 더하면 된다.
                // ex) 정수 4를 1,2,3으로 나타내는 방법은 1 + 2 + 4 = 7가지가 된다.
                else {
                    arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
                }
            }
            bw.write(arr[n]+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }


}

