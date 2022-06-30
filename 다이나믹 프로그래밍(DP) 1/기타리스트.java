import java.io.*;
import java.util.*;

/*   Baekjoon 1495번 - 기타리스트 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 30
*    메모리 : 15648 KB
*    시간 : 148 ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력력
       StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 곡의 개수
        int S = Integer.parseInt(st.nextToken());   // 시작 볼륨
        int M = Integer.parseInt(st.nextToken());   // 최대 볼륨 값

        int[] arr = new int[M+1]; // arr[볼륨 값] = m번째 곡, m번째 곡에서 볼륨 n으로 연주

        for(int i=0; i<M+1; i++){
            arr[i] = -1;
        }

        arr[S] = 0; // 0번째 곡에서 시작 볼륨으로 연주

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            int V = Integer.parseInt(st.nextToken()); // 볼륨의 차이 입력

            List<Integer> list = new ArrayList<>();

            for(int j=0; j<M+1; j++){
                // i번째 곡의 볼륨
                if(arr[j] == i-1){
                    int diff1 = j+V; // 이전 볼륨 + 현재 볼륨
                    int diff2 = j-V; // 이전 볼륨 - 현재 볼륨

                    // 볼륨의 범위를 넘어서지 않는다면
                    if(diff1>=0 && diff1<=M)
                        list.add(diff1);

                    if(diff2>=0 && diff2<=M)
                        list.add(diff2);
                }
            }

            // 각 볼륨 값 인덱스에 몇 번째 곡인지 저장
            for(int n : list)
                arr[n] = i;
        }

        int max = -1;

        for(int i=0; i<M+1; i++){
            // 마지막 곡의 볼륨을 탐색
            if(arr[i]==N)
                max = Math.max(max, i);
        }

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

