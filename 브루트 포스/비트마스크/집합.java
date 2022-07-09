import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11723번 - 집합 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 07 - 09
*    메모리 : 299620 KB
*    시간 : 1048 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M =Integer.parseInt(br.readLine()); // 연산의 수
        int bitset = 0;

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            int num;

            if(command.equals("add")){
                num = Integer.parseInt(st.nextToken());
                // 정수 1을 32 비트로 분해 후, (num-1) 만큼 왼쪽으로 비트 이동
                // (num-1)을 한 이유는 20이 들어오게 되면 실질적인 자리는 19번째 이기 때문에
                bitset |= (1 << (num-1));
            } else if(command.equals("remove")){
                num = Integer.parseInt(st.nextToken());
                // 정수 1을 32 비트로 분해 후, (num-1) 만큼 왼쪽으로 비트 이동하고 비트를 반전
                // 기존 bitset 에 저장된 비트와 & 논리 연산자로 0으로 바꾼다.
                bitset = bitset & ~(1 << (num-1));
            } else if(command.equals("check")){
                num = Integer.parseInt(st.nextToken());
                // 기존 bitset 에 저장된 비트와 & 논리 연산자를 통해 0인지 1인지 구분
                bw.write((bitset & (1 << (num-1))) != 0 ? "1\n" : "0\n");
            } else if(command.equals("toggle")){
                num = Integer.parseInt(st.nextToken());
                // 기존 bitset 에 저장된 비트를 ^ 연산자를 통해 두 비트를 비교하여
                // 0과 1이면 추가하고 비트가 겹치면 삭제한다.
                bitset ^= (1 << (num-1));
            } else if(command.equals("all")){
                // 기존 bitset 에 0 비트를 반전하여 | 연산자를 통해 모두 1로 바꾼다.
                bitset |= (~0);
            } else if(command.equals("empty")){
                // 기존 bitset 에 0과 & 연산자로 모두 0으로 바꾼다.
                bitset &= 0;
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }

}

