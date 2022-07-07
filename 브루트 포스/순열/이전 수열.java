import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 10973번 - 이전 순열 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 07
*    메모리 : 18012 KB
*    시간 : 224 ms
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


        if(prevPermutation()){
            for (int i=0; i<N; i++)
                bw.write(arr[i]+" ");
        } else {
            bw.write("-1");
        }
        bw.flush();

        bw.close();
        br.close();
    }
    // 이전 수열 탐색
    public static boolean prevPermutation(){
        int i = arr.length - 1;

        while(i>0 && arr[i-1] <= arr[i]) { i--; }
        if(i<=0) return false;

        int j = arr.length - 1;

        while(arr[i-1] <= arr[j]) { j--; }

        swap(i-1, j);

        j = arr.length - 1;
        while (i < j){
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

