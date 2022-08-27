import java.io.*;

/*   Baekjoon 14916번 - 거스름돈 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 27
*    메모리 : 14340 KB
*    시간 : 132 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 거스름돈 액수

        int count = 0;

        while(N>0){
            if(N%5==0){ // 5원짜리 동전으로 나누어진다면
                count += N/5;
                break;
            }

            // 5원짜리 동전으로 나누어지지 않는다면
            N -= 2;
            count++;
        }

        if(N<0) bw.write(-1+"");
        else bw.write(count+"");

        bw.close();
        br.close();
    }

}


