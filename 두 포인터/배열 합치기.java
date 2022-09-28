import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 11728번 - 배열 합치기 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 09 - 28
*    메모리 : 314508 KB
*    시간 : 1680 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 A, B의 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        // 배열 A 원소 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        // 배열 B 원소 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) B[i] = Integer.parseInt(st.nextToken());

        // 배열 A와 B의 원소들을 합친 결과를 저장
        int[] merge = new int[N+M];

        // 배열 A를 merge 배열에 저장
        for(int i=0; i<N; i++) merge[i] = A[i];
        // 배열 B를 merge 배열에 저장
        for(int i=N, j=0; i<N+M; i++,j++) merge[i] = B[j];

        // 오름차순으로 정렬
        Arrays.sort(merge);

        // merge 배열 출력
        for(int val : merge) bw.write(val+" ");
        bw.flush();

        bw.close();
        br.close();
    }
}



