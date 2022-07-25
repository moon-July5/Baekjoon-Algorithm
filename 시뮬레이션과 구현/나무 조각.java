import java.io.*;
import java.util.*;

/*   Baekjoon 2947번 - 나무 조각 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 25
*    메모리 : 14548 KB
*    시간 : 144 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<5; i++){
            for(int j=0; j<4; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);

                    for(int val : arr)
                        bw.write(val+" ");
                    bw.write("\n");
                }
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }

    public static void swap(int[] n, int a, int b){
        int temp = n[a];
        n[a] = n[b];
        n[b] = temp;
    }
}

