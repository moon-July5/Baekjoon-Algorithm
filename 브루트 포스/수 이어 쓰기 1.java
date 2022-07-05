import java.io.*;

/*   Baekjoon 1748번 - 수 이어 쓰기 1 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 07 - 05
*    메모리 : 15060 KB
*    시간 : 208 ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int len = 10;
        int answer = 0;

        for(int i=1; i<=N; i++){
            if(i==len){
                len *= 10;
                count++;
            }

            answer += count;
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

