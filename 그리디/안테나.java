import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 18310번 - 안테나 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 19
*    메모리 : 42492 KB
*    시간 : 580 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine()); // 집의 개수

        int[] arr = new int[N];

        // 집들의 위치 값 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 집들의 위치를 오름차순으로 정렬
        Arrays.sort(arr);

        // 안테나를 설치했을 때, 안테나로부터 모든 집까지의 최소 거리는 위치가 중간이면 된다.
        int mid = (N-1) / 2;

        bw.write(arr[mid]+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



