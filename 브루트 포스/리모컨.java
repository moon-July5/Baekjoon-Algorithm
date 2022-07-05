import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1107번 - 리모컨 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 07 - 05
*    메모리 : 15508 KB
*    시간 : 176 ms
 */

public class Main {
    private static boolean[] check = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수

        if(M!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                int m = Integer.parseInt(st.nextToken());
                check[m] = true; // 고장난 버튼의 인덱스에 true
            }
        }

        int answer = Math.abs(N-100); // 모든 버튼이 고장났을 경우, +,- 로만 이동할 수 있도록 설정

        for(int i=0; i<1000000; i++){
            int len = check(i); // n으로 버튼만을 이용해서 이동 가능한지, 가능하면 몇 번의 버튼을 눌러야하는지

            if(len > 0){
                int press = Math.abs(i - N);    // 숫자버튼으로 N에 인접하게 이동하여 +,-를 몇 번 눌러야하는지
                if(answer > len + press)
                    answer = len + press;
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // N에 근접하게 몇 번의 버튼만으로 이동 가능한지
    public static int check(int n){
        // 0으로 이동해야할 경우
        if(n==0) {
            // 0 버튼이 고장났을 경우
            if(check[0]) return 0;
            else return 1;
        }

        int len = 0;

        while(n > 0){
            if(check[n%10]) return 0;

            len += 1;
            n /= 10;
        }

        return len;
    }

}

