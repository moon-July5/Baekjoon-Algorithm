import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 17087번 - 숨바꼭질 6 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 19
*    메모리 : 27748 KB
*    시간 : 364 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N명의 동생
        int S = Integer.parseInt(st.nextToken()); // 현재 나의 위치

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            // 현재 나위 위치 - 동생 위치의 값을 절대값으로 저장
            arr[i] = Math.abs(S-arr[i]);
        }

        int D = arr[0]; // 모든 동생을 찾기 위한 이동 거리

        // 주어진 정수들의 최대공약수를 구한다.
        for(int i=1; i<N; i++){
            D = gcd(D, arr[i]);
        }
        bw.write(D+" ");

        bw.flush();
        bw.close();
        br.close();
    }

    // 유클리드 호제법 최대공약수
    public static int gcd(int a, int b){
        while(b != 0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

}

