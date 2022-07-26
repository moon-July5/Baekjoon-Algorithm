import java.io.*;
import java.util.*;

/*   Baekjoon 11504번 - 돌려 돌려 돌림판! (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 26
*    메모리 : 16452 KB
*    시간 : 172 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 돌림판 분할 수
            int M = Integer.parseInt(st.nextToken()); // 임의의 자리 수

            int x=0; int y=0;

            // x 값
            st = new StringTokenizer(br.readLine());
            for(int m=M; m>0; m--)
                x += Math.pow(10, m-1) * Integer.parseInt(st.nextToken());

            // y 값
            st = new StringTokenizer(br.readLine());
            for(int m=M; m>0; m--)
                y += Math.pow(10, m-1) * Integer.parseInt(st.nextToken());

           int[] arr = new int[N];

           // 돌림판의 숫자 입력
           st = new StringTokenizer(br.readLine());
           for(int i=0; i<N; i++)
               arr[i] = Integer.parseInt(st.nextToken());

           int count = 0;
           
           for(int i=0; i<N; i++){ // 돌림판의 숫자 만큼 반복
               int val = (int) Math.pow(10, M-1) * arr[i]; // 첫 번째 자리 
               for(int j=0; j<M-1; j++){ // M-1 번 만큼 반복
                    val += Math.pow(10, M-j-2) * arr[(i+j+1)%N]; // 자릿수 * 순환 배열
               }
               // x <= val <= y 이면
               if(val>=x && val<=y)
                   count++;
           }

           bw.write(count+"\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}

