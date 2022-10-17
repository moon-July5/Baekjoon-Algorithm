import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 7795번 - 먹을 것인가 먹힐 것인가 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 10 - 17
*    메모리 : 37408 KB
*    시간 : 1132 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // A의 수
            int M = Integer.parseInt(st.nextToken()); // B의 수

            int[] A = new int[N];
            int[] B = new int[M];

            // 생명체 A의 크기 입력
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++){
                A[n] = Integer.parseInt(st.nextToken());
            }

            // 생명체 B의 크기 입력
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                B[m] = Integer.parseInt(st.nextToken());
            }

            // A와 B의 크기를 오름차순으로 정렬
            Arrays.sort(A);
            Arrays.sort(B);

            // A가 B보다 큰 쌍의 개수
            int answer = 0;

            // 큰 쌍의 개수 연산
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    // A보다 B가 크거나 같다면 break
                    if(A[i]<=B[j]) break;

                    answer++;
                }
            }

            bw.write(answer+"\n");

        }
        bw.flush();

        bw.close();
        br.close();
    }
}



