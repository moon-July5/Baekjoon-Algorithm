import java.io.*;
import java.util.*;

/*   Baekjoon 10709번 - 기상캐스터 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 07 - 24
*    메모리 : 16240 KB
*    시간 : 164 ms
 */

public class Main {
    private static int H, W; // 세로, 가로 길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int count = 0;

        // 구름의 유무 입력
        for(int i=0; i<H; i++){
            String s = br.readLine();
            for(int j=0; j<W; j++){
              if(s.charAt(j)=='.' && count==0) // 구름이 없고 전 구역에도 구름이 없는 경우
                  bw.write(-1+" ");
              else if(s.charAt(j)=='c'){ // 구름이 있는 구역일 경우
                  bw.write(0+" ");
                  count = 1; // count를 1로 초기화
              }
              else if(s.charAt(j)=='.' && count!=0){ // 구름이 없지만 전 구역에 구름이 있는 경우
                  bw.write(count+" ");
                  count++;
              }
            }
            bw.write("\n");

            count = 0;
        }
        bw.flush();

        bw.close();
        br.close();
    }


}

