import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 10972번 - 다음 순열 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 07
*    메모리 : 18292 KB
*    시간 : 228 ms
 */

public class Main {
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        if(nextPermutation()){
            for(int i=0; i<N; i++){
                bw.write(arr[i]+" ");
            }
        } else {
            bw.write("-1");
        }
        bw.flush();

        bw.close();
        br.close();
    }
    // 다음 순열 탐색
    public static boolean nextPermutation(){
        // 마지막 인덱스부터 비교
        int i = arr.length - 1;

        // 현재 인덱스 - 1 (i-1)의 값보다 현재 인덱스 (i)의 값이 더 큰 값을 기준으로 한다.
        // 계속 비교하면서 i가 0보다 작거나 같다는 의미는 이미 사전순으로 마지막이기 때문에 false 반환
        while(i>0 && arr[i-1] >= arr[i]) { i--; }
        if(i <= 0) return false;

        // 위에서 탐색한 i 인덱스를 가지고 맨 마지막 인덱스부터 비교한다.
        int j = arr.length - 1;
        while(arr[i-1] >= arr[j]) { j--; }

        // 서로 바꾼다.
        swap(i-1, j);

        // 오름차순으로 정렬
        j = arr.length - 1;
        while(i < j){
            swap(i, j);
            i++; j--;
        }

        return true;
    }


    // 두 요소를 바꾸기
    public static void swap(int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}

