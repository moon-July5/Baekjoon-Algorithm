import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 1920번 - 수 찾기 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 10 - 18
*    메모리 : 49696 KB
*    시간 : 652 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 자연수의 개수

        int[] arr = new int[N];

        // N개의 정수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        int[] arr2 = new int[M];

        // M개의 정수 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) arr2[i] = Integer.parseInt(st.nextToken());

        // 오름차순 정렬
        Arrays.sort(arr);

        for(int i=0; i<M; i++)
            bw.write(binarySearch(arr, arr2[i])+"\n");

        bw.flush();

        bw.close();
        br.close();
    }

    // 이분 탐색
    public static int binarySearch(int[] arr, int value){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        while(low <= high){
            // 중간 인덱스
            mid = (low+high) / 2;

            // 맞는 정수가 있다면 1 반환
            if(arr[mid] == value) return 1;
            // 탐색하려는 정수보다 크다면 끝 인덱스를 (중간 인덱스 - 1)로 갱신
            else if(arr[mid] > value) high = mid - 1;
            // 탐색하려는 정수보다 작다면 시작 인덱스를 (중간 인덱스 + 1)로 갱신
            else if(arr[mid] < value) low = mid + 1;
        }

        // 맞는 정수가 없다면 0 반환
        return 0;
    }
}



