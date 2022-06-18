import java.io.*;
import java.util.StringTokenizer;


/*   Baekjoon 1978번 - 소수 찾기 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 18
*    메모리 : 14216 KB
*    시간 : 132 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 소수가 아닌 정수는 true, 소수가 맞으면 false를 나타내는 배열
        boolean[] isNotPrime = new boolean[1001];
        isNotPrime[0] = true; isNotPrime[1] = true;

        // 에라토스테네스의 체의 소수 판별법
        // 2, 3, 5, 7을 제외한 2의 배수, 3의 배수, 5의 배수, 7의 배수들을 true로 저장
        for(int i=2; i<isNotPrime.length; i++){
            if(isNotPrime[i]) continue;

            for(int j=i+i; j<isNotPrime.length; j+=i){
                isNotPrime[j] = true;
            }
        }

        int count = 0;

        // 소수 찾기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());

            if(!isNotPrime[n])
                count++;
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
