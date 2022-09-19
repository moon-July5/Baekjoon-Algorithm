import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 13305번 - 주유소 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 19
*    메모리 : 35352 KB
*    시간 : 380 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 도시의 개수

        int[] road = new int[N-1];
        int[] price = new int[N];

        long distance = 0;

        // 인접한 두 도시를 연결하는 도로의 길이 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
            distance += road[i];
        }
        // 주유소의 리터당 가격 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            price[i] = Integer.parseInt(st.nextToken());

        long answer = 0; // 최소 가격
        long minPrice = price[0]; // 주유소의 리터당 최소 가격

        for(int i=0; i<N-1; i++){
            // 주유소의 리터당 최소 가격 갱신
            if(minPrice > price[i]) minPrice = price[i];

            // 인접한 도시 사이의 길이에 따라 가격 계산
            answer += (road[i] * minPrice);
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



