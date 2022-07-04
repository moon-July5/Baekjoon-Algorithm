import java.io.*;
import java.util.Arrays;

/*   Baekjoon 2309번 - 일곱 난쟁이 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 04
*    메모리 : 15868 KB
*    시간 : 144 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 난쟁이들의 키를 담을 공간
        int[] arr = new int[9];

        // 난쟁이들의 키의 합
        int sum = 0;

        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        boolean flag = false;

        for(int i=0; i<9; i++){
            // flag 가 true 일 경우, 일곱 난쟁이들의 키를 발견했기 때문에 break
            if(flag) break;

            for(int j=0; j<9; j++){
                if(i==j) continue;
                // 난쟁이들의 키의 합에서 두 명의 난쟁이들의 합을 빼면 100이 될 경우,
                // 즉, 그 두 명의 난쟁이들은 진짜 일곱 난쟁이들이 아님을 판별
                if(sum - (arr[i] + arr[j]) == 100){
                    flag = true; // flag를 true로 변환
                    arr[i] = 0; arr[j] = 0; // 0으로 저장
                }
            }
        }
        // 오름차순으로 정렬
        Arrays.sort(arr);

        for(int i=2; i<9; i++)
            bw.write(arr[i]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

}

