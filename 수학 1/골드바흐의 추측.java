import java.io.*;

/*   Baekjoon 6588번 - 골드바흐의 추측 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 19
*    메모리 : 29296 KB
*    시간 : 436 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isNotPrime = new boolean[1000001];    // 소수인지 아닌지 판별, 소수면 false, 아니면 true

        // 에라토스테네스의 체 소수 판별법
        for(int i=2; i<isNotPrime.length; i++){
            if(isNotPrime[i]) continue;

            for(int j=i+i; j<isNotPrime.length; j+=i){
                isNotPrime[j] = true;
            }
        }

        int n;

        // 골드바흐의 추측
        // 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
        while((n = Integer.parseInt(br.readLine())) != 0){
            // 골드바흐의 추측이 맞는지 판별
            boolean check = false;

            for(int i=3; i<n; i++){
                // 두 수가 소수인지 판별
                // 조건 중에 두 소수의 차가 가장 커야 한다.
                if(!isNotPrime[i] && !isNotPrime[n-i]){
                    bw.write(n+" = "+i+" + "+(n-i)+"\n");
                    check = true;
                    break;
                }
            }

            // 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우
            if(!check){
                bw.write("Goldbach's conjecture is wrong.");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
