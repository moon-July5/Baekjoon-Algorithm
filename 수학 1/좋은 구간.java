import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 1059번 - 좋은 구간 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 09 - 09
*    메모리 : 14408 KB
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine()); // 집합 S의 크기 L

        int[] arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<L; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine()); // N을 포함하는 좋은 구간

        Arrays.sort(arr); // 집합 S를 오름차순 정렬

        int sIdx=0, eIdx=0; // 시작, 끝 인덱스

        // 집합 S의 크기만큼 반복
        for(int i=0; i<L; i++){
            // 집합 S에 속한 값 중에서 N보다 크거나 같은 값의 인덱스를 탐색
            if(arr[i] >= N){
                sIdx = i-1; eIdx = i;
                break;
            }
        }

        int left = sIdx == -1 ? N : N-arr[sIdx];
        int right = arr[eIdx] - N;

        bw.write((left*right==0 ? 0 : left*right-1) +"");
        bw.close();
        br.close();
    }
}



