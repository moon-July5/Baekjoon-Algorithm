import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 2776번 - 암기왕 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 10 - 19
*    메모리 : 250652 KB
*    시간 : 1996 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            // 수첩 1에 적어 놓은 정수의 개수
            int N = Integer.parseInt(br.readLine());

            int[] note1 = new int[N];

            // 수첩 1에 적혀 있는 정수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) note1[i] = Integer.parseInt(st.nextToken());

            // 수첩 2에 적어 놓은 정수의 개수
            int M = Integer.parseInt(br.readLine());

            int[] note2 = new int[M];

            // 수첩 2에 적혀 있는 정수 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) note2[i] = Integer.parseInt(st.nextToken());

            // 오름차순 정렬
            Arrays.sort(note1);

            for(int i=0; i<M; i++)
                bw.write(binarySearch(note1, note2[i])+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    // 이분 탐색
    public static int binarySearch(int[] arr, int value){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            // 중간 값
            int mid = (start+end) / 2;

            // 찾으려는 값을 발견한 경우 1 반환
            if(arr[mid]==value) return 1;
            // 찾으려는 값보다 큰 경우 끝 인덱스를 (mid - 1)로 갱신
            else if(arr[mid] > value) end = mid - 1;
            // 찾으려는 값보다 작은 경우 시작 인덱스를 (mid + 1)로 갱신
            else if(arr[mid] < value) start = mid + 1;
        }

        // 찾으려는 값을 발견하지 못한 경우 0 반환
        return 0;
    }
}



