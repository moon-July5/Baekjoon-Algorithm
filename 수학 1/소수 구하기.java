import java.io.*;
import java.util.StringTokenizer;


/*   Baekjoon 1929번 - 소수 구하기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 18
*    메모리 : 23396 KB
*    시간 : 352 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isNotPrime = new boolean[N+1];
        isNotPrime[1] = true;

        // 에라토스테네스의 체 소수 판별법
        for(int i=2; i<isNotPrime.length; i++){
            if(isNotPrime[i]) continue;

            for(int j=i+i; j<isNotPrime.length; j+=i){
                isNotPrime[j] = true;
            }
        }

        // M ~ N 범위 안에서의 소수 출력
        for(int i=M; i<=N; i++){
            if(!isNotPrime[i]) bw.write(i+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
