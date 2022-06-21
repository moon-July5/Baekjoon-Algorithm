import java.io.*;

/*   Baekjoon 11727번 - 2Xn 타일링 2 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 20
*    메모리 : 14312 KB
*    시간 : 140 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        for(int i=0; i<N+1; i++){
            if(i <= 1) {
                arr[i] = i;
            } else if(i == 2){ // 2X2 타일링일 경우
                arr[i] = 3;
            } else { 
                arr[i] = (2*arr[i-2] + arr[i-1]) % 10007;
            }
        }
        bw.write(arr[N]+"");

        bw.close();
        br.close();
    }


}

