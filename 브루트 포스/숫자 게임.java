import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 2303번 - 숫자 게임 (Silver Ⅴ)
*    문제 푼 날짜 : 2022 - 09 - 08
*    메모리 : 14680 KB
*    시간 : 144 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 사람의 수

        int answer = 0;
        int max = 0; // 세 수의 합에서 일의 자리가 가장 큰 값

        for(int n=1; n<=N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[5];

            // 다섯 장의 카드 정보 입력
            for(int i=0; i<5; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            // 모든 경우의 수를 탐색
            for(int i=0; i<arr.length-2; i++){
                for(int j=i+1; j<arr.length-1; j++){
                    for(int k=j+1; k<arr.length; k++){
                        int sum = arr[i] + arr[j] + arr[k]; // 5장의 카드 중에서 3장 선택하여 모두 더한다.

                        sum %= 10; // 일의 자리 수 추출

                        if(sum >= max){ // 다른 카드 조합의 일의 자리수가 크다면
                            max = sum; // 최댓값 갱신
                            answer = n; // 일의 자리 수가 가장 큰 사람의 번호 갱신
                        }
                    }
                }
            }
        }
        
        bw.write(answer+"");

        bw.close();
        br.close();
    }
}



