import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 9613번 - GCD 합 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 19
*    메모리 : 14616 KB
*    시간 : 144 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            
            // 두 정수의 최대공약수 값을 찾아 누적해서 더한다.
            for(int j=0; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    sum += gcd(arr[j],arr[k]);
                }
            }
            bw.write(sum+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 유클리드 호제법의 최대공약수
    public static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

