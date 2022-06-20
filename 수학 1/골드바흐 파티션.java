import java.io.*;

/*   Baekjoon 17103번 - 골드바흐 파티션 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 06 - 20
*    메모리 : 18444 KB
*    시간 : 324 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수

        boolean[] isNotPrime = new boolean[1000001]; // 소수를 판별할 변수
        isNotPrime[1] = true;

        // 에라토스테네스의 체 소수 판별법
        for(int i=2; i<isNotPrime.length; i++){
            if(isNotPrime[i]) continue;

            for(int j=i+i; j<isNotPrime.length; j+=i){
                isNotPrime[j] = true;
            }
        }

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());    // 짝수

            // 두 소수의 합 개수
            int count = 0;

            // 두 소수의 합을 구하기 위한 for 문
            // 여기서 두 소수의 순서만 다른 것이기 때문에 n/2 범위까지만 확인한다.
            for(int j=2; j<=n/2; j++){
                // 두 소수의 합이 N으로 나타낼 수 있는지 확인
                if(!isNotPrime[j] && !isNotPrime[n-j]){
                    count++;
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }


}

