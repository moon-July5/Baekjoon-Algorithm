import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 2502번 - 떡 먹는 호랑이 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 15
*    메모리 : 16000 KB
*    시간 : 156 ms
 */

public class Main {
    private static int D, K; // 할머니가 넘어온 날, 그 날 호랑이에게 떡을 준 개슈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(D==3){ // 할머니가 넘어온 날이 3이면, 1일차와 2일차의 떡 개수를 출력
            System.out.println(1);
            System.out.println(K-1);
            return;
        }

        // 날마다 1일차와 2일차를 이용하여 식을 설정할 때, 그에 따른 계수를 저장
        // ex) 3일차의 떡 개수를 구할 때, A3 = A1 + A2, A4 = A1 + A2 * 2
        int[] arr1 = new int[D+1];
        int[] arr2 = new int[D+1];

        arr1[3] = arr2[3] = 1; // A3 = A1 + A2
        arr1[4] = 1; arr2[4] = 2;// A4 = A1 + A2 * 2

        // xA1 + yA2 형식으로 변환
        for(int i=5; i<=D; i++){
            arr1[i] = arr1[i-1] + arr1[i-2];
            arr2[i] = arr2[i-1] + arr2[i-2];
        }

        int firstDay = 0;
        int secondDay = 0;

        // 식의 A1과 A2의 해를 구함
        for(int i=1; ;i++){
            int val = K - arr1[D] * i;

            if(val%arr2[D] == 0){
                firstDay = i;
                secondDay = val / arr2[D];
                break;
            }
        }

        bw.write(firstDay+"\n"+secondDay);
        bw.flush();

        bw.close();
        br.close();
    }
}



