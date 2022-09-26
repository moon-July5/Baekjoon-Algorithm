import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 2979번 - 트럭 주차 (Bronze Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 26
*    메모리 : 14276 KB
*    시간 : 124 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 주차 요금 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 트럭을 한 대 주차할 때
        int B = Integer.parseInt(st.nextToken()); // 트럭을 두 대 주차할 때
        int C = Integer.parseInt(st.nextToken()); // 트럭을 세 대 주차할 때

        int[][] arr = new int[3][2];
        int[] numberOfTrucks = new int[100];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 트럭이 주차장에 도착한 시간과 떠나는 시간 입력
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;

            // 시간별로 트럭이 몇 대 주차되어있는지 계산
            for(int j=start; j<end; j++)
                numberOfTrucks[j]++;

            // 가장 빠른 주차 시간과 늦은 주차 시간 저장
            min = Math.min(min, start);
            max = Math.max(max, end);
        }

        int answer = 0;

        // 주차 요금 계산
        for(int i=min; i<max; i++){
            answer += (numberOfTrucks[i]==1) ? numberOfTrucks[i] * A : 0;
            answer += (numberOfTrucks[i]==2) ? numberOfTrucks[i] * B : 0;
            answer += (numberOfTrucks[i]==3) ? numberOfTrucks[i] * C : 0;
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



