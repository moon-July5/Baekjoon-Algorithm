import java.io.*;
import java.util.*;

/*   Baekjoon 1244번 - 스위치 켜고 끄기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 30
*    메모리 : 15960 KB
*    시간 : 160 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 스위치의 개수

        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine()); // 학생 수

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); // 성별
            int number = Integer.parseInt(st.nextToken()); // 학생이 받은 수

            if(gender==1) { //  남학생일 경우
                for(int i=number; i<=N; i+=number)
                    arr[i] ^= 1;
            } else if(gender==2){ // 여학생일 경우
                int start = number-1;
                int end = number+1;

                while(start >=1 && end <=N) {	// 스위치 범위 안에서 반복
                    if(arr[start] != arr[end]) break;	// 좌우 대칭 아니면 탈출
                    start--;
                    end++;
                }
                start++; end--;	// 좌우 대칭이 아니기 바로 전 상태는 좌우 대칭

                for(int i = start; i <= end; i++) {
                    arr[i] ^= 1;	// XOR 연산으로 스위치 토글
                }
            }
        }

        // 출력
        for(int i=1; i<=N; i++) {
            if(i%20==1 && i != 1){ // 한 줄에 20개씩 출력하기 위한 조건 
                bw.write("\n");
            }
            bw.write(arr[i] + " ");
        }
        bw.flush();
        
        bw.close();
        br.close();
    }

}

