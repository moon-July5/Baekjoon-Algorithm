import java.io.*;

/*   Baekjoon 11726번 - 2Xn 타일링 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 20
*    메모리 : 14380 KB
*    시간 : 212 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        for(int i=0; i<N+1; i++){
            if(i<=2) arr[i] = i;
            else{
                // i-1 번째와 i-2 번째 방법의 수를 합한 것이 i 번째 방법의 수이다.
                arr[i] = (arr[i-1] + arr[i-2]) % 10007;
            }
        }
        
        bw.write(arr[N]+"");

        bw.close();
        br.close();
    }


}

