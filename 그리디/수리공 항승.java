import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 1449번 - 수리공 항승 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 19
*    메모리 : 14392 KB
*    시간 : 132 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
        int L = Integer.parseInt(st.nextToken()); // 테이프의 길이

        int[] arr = new int[N];

        // 물이 새는 곳의 위치 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // 오름차순 정렬

        int answer = 1;
        double value = arr[0] - 0.5; // 물을 막을 때, 좌우 0.5 만큼 간격을 줘야 물을 막을 수 있다.

        for(int i=0; i<N; i++){
            if(value+L < arr[i]){ // 테이프로 막은 위치보다 떨어져 있다면
                answer++; // count
                value = arr[i] - 0.5; // 테이프로 막은 위치 갱신
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



