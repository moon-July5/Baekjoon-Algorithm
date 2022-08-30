import java.io.*;
import java.util.*;

/*   Baekjoon 2002번 - 추월 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 30
*    메모리 : 14388 KB
*    시간 : 136 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 차량의 수

        HashMap<String, Integer> hashMap = new HashMap<>();

        // 터널 입구에서 대근이가 작성한 차량 번호 입력
        for(int i=0; i<N; i++)
            hashMap.put(br.readLine(), i);

        int answer = 0;

        int[] output = new int[N]; // 터널 출구로 나간 차량 순서 저장

        // 터널 출구에서 영식이가 작성한 차량 번호 입력
        for(int i=0; i<N; i++)
            // 차량 번호 순서를 저장
            output[i] = hashMap.get(br.readLine());

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                // 터널 입구에서 뒤에 있던 차가 터널 출구에서 추월했다는 의미
                if(output[i] > output[j]) {
                    answer++;
                    break;
                }
            }
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }
}


