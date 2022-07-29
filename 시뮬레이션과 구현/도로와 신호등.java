import java.io.*;
import java.util.*;

/*   Baekjoon 2980번 - 도로와 신호등 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 07 - 28
*    메모리 : 14248 KB
*    시간 : 136 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 신호등의 개수
        int L = Integer.parseInt(st.nextToken()); // 도로의 길이

        int pos=0, time=0;

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken()); // 신호등 위치
            int R = Integer.parseInt(st.nextToken()); // 빨간색 지속 시간
            int G = Integer.parseInt(st.nextToken()); // 초록색 지속 시간

            time += D - pos; // 다음 위치까지 가는데 걸리는 시간
            pos = D; // 위치 이동

            int section = time % (R + G); // 신호등 사이클 확인(현재 신호등이 무슨 색인지)

            if(section < R) time += R - section; // 빨간색 구간 임을 나타냄
        }

        // 남은 신호등 거리 계산
        bw.write(time + L - pos +"");
        bw.flush();

        bw.close();
        br.close();
    }

}

