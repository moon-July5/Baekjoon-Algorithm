import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 1049번 - 기타줄 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 18
*    메모리 : 14448 KB
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄의 개수
        int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드

        int[] pack = new int[M];
        int[] one = new int[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken()); // 브랜드 6줄 패키지 가격
            one[i] = Integer.parseInt(st.nextToken()); // 낱개의 가격
        }

        // 가장 가격이 싼 순서로 정렬
        Arrays.sort(pack);
        Arrays.sort(one);

        int min = Integer.MAX_VALUE;

        min = Math.min((N/6+1) * pack[0], N * one[0]); // 가장 가격이 싼 패키지 또는 낱개로 샀을 때, 최솟값
        min = Math.min(min, ((N/6)*pack[0]) + ((N%6) * one[0])); // 가장 가격이 싼 패키지와 함께 낱개로 샀을 때에도 비교

        bw.write(min+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



