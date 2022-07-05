import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 6064번 - 카잉 달력 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 05
*    메모리 : 41852 KB
*    시간 : 712 ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 카잉 달력의 마지막 해
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            boolean check = false;

            for(int i=x; i<M*N; i+=M){
                if(i%N == y){
                    bw.write(i+1+"\n");
                    check = true;
                    break;
                }
            }

            if(!check) bw.write(-1+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

}

