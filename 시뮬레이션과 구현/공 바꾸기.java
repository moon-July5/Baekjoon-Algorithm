import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 10813번 - 공 바꾸기 (Bronze Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 27
*    메모리 : 15900 KB
*    시간 : 148 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 바구니의 개수
        int M = Integer.parseInt(st.nextToken()); // 공을 교환할 횟수

        int[] arr = new int[N+1];

        // 바구니에 들어간 공 번호 입력
        for(int i=1; i<=N; i++) arr[i] = i;

        // 공을 교환할 방법 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            swap(arr, a, b);
        }

        // 교환된 공의 번호를 1 ~ N 까지 출력
        for(int val : arr){
            if(val!=0) bw.write(val+" ");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    // 공을 교환하는 메서드
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}



