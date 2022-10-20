import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 17266번 - 어두운 굴다리 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 10 - 20
*    메모리 : 24832 KB
*    시간 : 348 ms
 */

public class Main {
    private static int N, M;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 굴다리의 길이 입력
        N = Integer.parseInt(br.readLine());
        // 가로등의 개수 입력
        M = Integer.parseInt(br.readLine());

        arr = new int[M];

        // M개의 설치할 수 있는 가로등의 위치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        int start = 1;
        int end = N;

        while(start <= end){
            int mid = (start + end) / 2;

            // mid 높이로 모든 지점을 비출 수 있다면 answer 갱신 후 높이를 줄여 재탐색
            if(solve(mid)){
                answer = mid;
                end = mid - 1;
            // 모든 지점을 비출 수 없다면 높이를 높여 재탐색
            } else start = mid + 1;
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static boolean solve(int height){
        // 이전 가로등이 비친 마지막 지점
        int prev = 0;

        for(int i=0; i<arr.length; i++){
            /*  가로등이 있는 지점에서 비출 수 있는 높이를 빼면 가로등이 비추는 최솟값을 확인할 수 있다.
            *   이 최솟값을 기준으로 가로등이 빈곳 없이 다 비추는지 조건 확인
                arr[i] + height를 하게되면 가로등이 다시 비춰야만 하는 최솟값을 반환할 수 있다.
             */
            if(arr[i]-height <= prev) prev = arr[i] + height;
            /*
                가로등의 시작 지점에서 높이만큼 비춘 곳이
                이전 가로등이 마지막으로 비춘 곳에 도달하지 못하면 모든 지점을 비출 수 없다.
             */
            else return false;
        }

        /*
            마지막 지점도 가로등이 비출 수 있는지 확인
            마지막 가로등 비출 수 있는 끝 지점에서 굴다리 끝 좌표를 뺐을 때 0보다 작거나 같아야 한다.
         */
        return N-prev <= 0;
    }

}



