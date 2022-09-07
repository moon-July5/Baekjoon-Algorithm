import java.io.*;

/*   Baekjoon 1526번 - 가장 큰 금민수 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 07
*    메모리 : 14736 KB
*    시간 : 144 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 정수 입력

        for(int i=N; i>=0; i--){
            boolean flag = true; // 금민수인지 판별
            int val = i;

            while(val>0){
                int rem = val % 10; // 각 자릿수 확인
                // 각 자릿수가 4 또는 7이면 10으로 나눠 다른 자리의 숫자를 확인할 수 있게한다.
                if(rem==4 || rem==7) val /= 10;
                else { // 만약 각 자릿수가 4 또는 7이 아니면 금민수가 아니기 때문에 종료
                    flag = false;
                    break;
                }
            }

            // flag가 true라는 의미는 금민수로 판별되어 값을 출력 후 종료한다.
            if(flag) {
                bw.write(i + "");
                break;
            }
        }

        bw.close();
        br.close();
    }
}



