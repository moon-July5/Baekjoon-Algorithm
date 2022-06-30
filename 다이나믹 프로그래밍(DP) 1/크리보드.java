import java.io.*;

/*   Baekjoon 11058번 - 크리보드 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 30
*    메모리 : 14364 KB 
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 크리보드의 버튼을 누른 횟수

        long[] arr = new long[N+1];

        for(int i=1; i<N+1; i++){
            // 1 ~ 6 까지는 1 ~ 6 값 그대로 저장
            arr[i] = arr[i-1] + 1;

            if(i>6){
                // 전체선택 -> 복사 -> 붙여넣기 3번의 동작 필요, 붙여넣기 이후 계속 붙여 넣을 수 있음
                // 예를 들어, 7번 누를 때 최대 개수는 A를 4개 까지 만든 후 복사, 붙여넣기를 하면 8개를 만들 수 있다.
                // A를 3개 만든 후 복사, 붙여넣기 후, 또 붙여넣어서 9개 만들 수 있어 최댓값이 된다.
                for(int j=2; j<5; j++){
                    arr[i] = Math.max(arr[i], arr[i-(j+1)]*j);
                }
            }
        }

        bw.write(arr[N]+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

