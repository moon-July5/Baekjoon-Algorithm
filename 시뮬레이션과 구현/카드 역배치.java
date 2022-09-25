import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 10804번 - 카드 역배치 (Bronze Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 25
*    메모리 : 15960 KB
*    시간 : 152 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[21];

        // 1부터 20까지 오름차순으로 저장
        for(int i=1; i<arr.length; i++) arr[i] = i;

        // 10개의 구간 입력
        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // [a, b] 구간의 중간 인덱스 추출
            int mid = (b-a + 1) / 2;

            // a 인덱스부터 [a, b] 구간의 중간 인덱스까지 반복.
            // a 인덱스와 [a, b] 구간의 마지막 인덱스를 서로 바꿔주고, 다시 a+1 인덱스와 마지막 전의 인덱스를 서로 바꿔주는 식으로 동작
            // 그래서 idx 변수는 마지막 인덱스부터 마지막 전 인덱스들을 추출하기 위해 사용
            for(int j=a, idx=0; j<a+mid; j++,idx++){
                swap(arr, j, b-idx);
            }
        }

        for(int i=1; i<arr.length; i++)
            bw.write(arr[i]+" ");
        bw.flush();

        bw.close();
        br.close();
    }

    // 원소들을 서로 바꿔주는 메서드
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}



