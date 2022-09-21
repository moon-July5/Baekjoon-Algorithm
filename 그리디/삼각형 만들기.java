import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/*   Baekjoon 1448번 - 삼각형 만들기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 21
*    메모리 : 100716 KB
*    시간 : 1932 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 빨대의 개수

        Integer[] arr = new Integer[N];

        // 빨대의 길이 입력
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 빨대의 길이가 가장 긴 순서로 정렬 (내림차순 정렬)
        Arrays.sort(arr, Comparator.reverseOrder());

        // 삼각형이 될 수 있는지 확인
        boolean check = false;

        // 최댓값
        long answer = 0;

        for(int i=0; i<N-2; i++){
            // 빨대의 가장 긴 길이가 나머지 두 개의 빨대의 길이를 합한 값보다 작다면 삼각형이 성립.
            // 삼각형이 성립하면 최댓값을 구한 후 종료
            if(arr[i] < arr[i+1] + arr[i+2]){
                check = true;
                answer += arr[i] + arr[i+1] + arr[i+2];
                break;
            } else continue;
        }

        // check가 false면 삼각형이 성립이 안되었기 때문에 -1 출력
        if(!check) bw.write(-1+"");
        else bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



