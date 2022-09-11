import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 2548번 - 대표 자연수 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 11
*    메모리 : 18492 KB
*    시간 : 400 ms
 */

public class Main {
    private static int N; // 자연수의 개수
    private static int[] arr;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        // N개의 자연수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 대표 자연수가 두 개 이상일 경우 작은 것을 출력하기 위해, 오름차순으로 정렬
        Arrays.sort(arr);

        // 대표 자연수
        int answer = 0;

        // 대표 자연수를 찾기 위해 모든 경우의 수를 비교
        for(int i=0; i<N; i++){
            int sum = 0; // 비교하려는 자연수의 차이를 저장
            boolean flag = false;

            for(int j=0; j<N; j++){
                sum += Math.abs(arr[i] - arr[j]);
            }

            // 대표 자연수는 차이들의 합이 최소인 경우이기 때문에 갱신하는 과정을 거침
            if(min > sum){
                min = sum;
                flag = true;
            }
        
            // 만약 flag가 true일 경우, 대표 자연수를 탐색했다는 의미이므로 그 값을 저장
            if(flag) answer = arr[i];
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



