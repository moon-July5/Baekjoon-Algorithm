import java.io.*;

/*   Baekjoon 1747번 - 소수&팰린드롬 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 14
*    메모리 : 18660 KB
*    시간 : 504 ms
 */

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println(2);
            System.exit(0);
        }

        for(int i=N;;i++){
            // 소수이고 팰린드롬이면 숫자를 출력 후 종료
            if(isPrime(i) && check(i)){
                System.out.println(i);
                System.exit(0);
            }
        }

    }
    // 소수 판별
    public static boolean isPrime(int value){
        // 제곱근을 이용하여 소수 판별
        for(int i=2; i<=Math.sqrt(value); i++){
            if(value%i == 0) return false;
        }

        return true;
    }

    // 팰린드롬 여부 확인
    public static boolean check(int value){
        String str = String.valueOf(value);

        for(int i=0; i<=str.length()/2; i++){
            // 숫자의 맨 앞과 맨 뒤에서부터 비교하여 같지 않다면 팰린드롬이 아니기 때문에 false 반환
            if(str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }

        return true;
    }

}



