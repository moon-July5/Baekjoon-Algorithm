import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 10816번 - 숫자 카드 2 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 10 - 19
*    메모리 : 140372 KB
*    시간 : 1516 ms
 */

public class Main {
    private static int[] arr;
    private static int[] arr2;
    private static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 숫자 카드의 개수
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        // 숫자 카드에 적혀있는 정수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 오름차순 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        arr2 = new int[M];
        answer = new int[M];

        // 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야할 M개의 정수 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
            answer[i] = upperBound(arr2[i]) - lowerBound(arr2[i]);
        }

        for(int value : answer)
            bw.write(value+" ");
        bw.flush();

        bw.close();
        br.close();
    }

    // 이진 탐색 - lowerBound
    // 찾는 값이 처음 나오는 위치 탐색
    public static int lowerBound(int value) {
        int start = 0 ;
        int end = arr.length;

        while(start < end){
            int mid = (start+end) / 2;

            if(value <= arr[mid]) end = mid;
            else start = mid + 1;
        }

        return start;
    }

    // 이진 탐색 - upperBound
    // 찾는 값보다 초과한 값이 처 나오는 위치 탐색
    public static int upperBound(int value){
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = (start+end) / 2;

            if(value < arr[mid]) end = mid;
            else start = mid + 1;
        }

        return start;
    }

}



