import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1476번 - 날짜계산 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 07 - 04
*    메모리 : 14244 KB
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()); // 지구를 나타내는 수
        int S = Integer.parseInt(st.nextToken()); // 태양를 나타내는 수
        int M = Integer.parseInt(st.nextToken()); // 달을 나타내는 수

        // 지구, 태양, 달을 나타내는 초기값
        int e=1, s=1, m=1;

        // for 문 안에 있는 변수 i는 년도를 나타냄
        for(int i=1;;i++){
            // 입력으로 주어진 지구, 태양, 달의 수와 일치하면 출력 후 종료
            if(e==E && s==S && m==M){
                bw.write(i+"");
                break;
            }

            e++; s++; m++;

            // 지구, 태양, 달을 나타내는 수가 범위를 넘어서면 초기화
            if(e==16) e = 1;
            if(s==29) s = 1;
            if(m==20) m = 1;
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

