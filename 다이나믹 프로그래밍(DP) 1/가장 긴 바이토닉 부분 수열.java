import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11054번 - 가장 긴 바이토닉 부분 수열 (Gold Ⅲ)
*    문제 푼 날짜 : 2022 - 06 - 24
*    메모리 : 15460 KB
*    시간 : 164 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수열의 크기

        int[] arr = new int[N]; // 수열을 저장
        int[] inc = new int[N]; // 증가하는 수열의 길이를 저장
        int[] dec = new int[N]; // 감소하는 수열의 길이를 저장

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 증가하는 수열
        for(int i=0; i<N; i++){
            inc[i] = 1;

            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && inc[i]<=inc[j]){
                    inc[i] = inc[j] + 1;
                }
            }
        }

        // 감소하는 수열
        // 배열의 마지막 인덱스부터 시작
        for(int i=N-1; i>=0; i--){
            dec[i] = 1;

            for(int j=N-1; j>i; j--){
                if(arr[i]>arr[j] && dec[i]<=dec[j]){
                    dec[i] = dec[j] + 1;
                }
            }
        }

        int max = 0;
        
        /*
            바이토닉 수열은 증가하는 수열과 감소하는 수열이 합쳐져 있다고 볼 수 있다.
            그래서 증가하는 수열의 길이를 나타내는 inc 배열과 감소하는 수열의 길이를 나타내는 dec 배열을
            더한 상태에서 그 중 가장 큰 값이 바이토닉 수열의 가장 긴 길이다.
         */
        for(int i=0; i<N; i++){
            if(max < inc[i]+dec[i]){
                max = inc[i]+dec[i];
            }
        }

        // inc 배열과 dec 배열을 합친 것이기 때문에 원소가 1개씩 중복되어있다.
        // 따라서 max 값에서 1을 빼야한다.
        bw.write(max-1+"");
        bw.flush();

        bw.close();
        br.close();
    }


}

