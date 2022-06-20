import java.io.*;

/*   Baekjoon 1463번 - 1로 만들기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 20
*    메모리 : 18312 KB
*    시간 : 156 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        arr[0] = arr[1] = 0;

        for(int i=2; i<N+1; i++){
            // 먼저 1을 빼는 연산 진행
            arr[i] = arr[i-1] + 1;

            // 2로 나누어 떨어질 경우
            if(i%2 == 0){
                // 1을 뺀 연산과 2로 나눈 연산 중 최솟값 선택
                arr[i] = Math.min(arr[i], arr[i/2]+1);
            }
            // 3으로 나누어 떨어질 경우
            if(i%3 == 0){
                // 1을 뺀 연산과 3으로 나눈 연산 중 최솟값 선택
                arr[i] = Math.min(arr[i], arr[i/3]+1);
            }
        }
        bw.write(arr[N]+"");

        bw.close();
        br.close();
    }


}

