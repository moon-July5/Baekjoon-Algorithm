import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 11497번 - 통나무 건너뛰기 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 23
*    메모리 : 48264 KB
*    시간 : 556 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine()); // 통나무의 개수

            int[] arr = new int[N];
            int[] sortedArr = new int[N];

            // 각 통나무의 높이 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr); // 오름차순 정렬

            // 인접한 통나무의 높이의 차가 최소가 되게 하기 위해서 정렬
            // 통나무의 높이가 점점 증가하다 감소하는 형태로 정렬하게 되면 인접한 통나무의 높이의 차가 최소가 된다.
            int startIdx = 0;
            int endIdx = N-1;

            for(int i=0; i<N; i++){
                if(i%2==0){ // 짝수 인덱스일 경우, 시작부터 점점 증가하는 형태로 저장
                    sortedArr[startIdx] = arr[i];
                    startIdx++;
                } else { // 홀수 인덱스일 경우, 끝에서부터 점점 감소하는 형태로 저장
                    sortedArr[endIdx] = arr[i];
                    endIdx--;
                }
            }

            // 인접한 통나무의 높이의 차 계산
            int answer = Math.abs(sortedArr[0] - sortedArr[1]);

            // 인접한 통나무의 높이의 차가 최대인 경우 계산
            for(int i=1; i<N-1; i++){
                answer = Math.max(answer, Math.abs(sortedArr[i] - sortedArr[i+1]));
            }

            bw.write(answer+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



