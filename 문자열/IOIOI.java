import java.io.*;

/*   Baekjoon 5525번 - IOIOI (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 28
*    메모리 : 25980 KB
*    시간 : 275 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 'I'가 N+1개, 'O'가 N개, 'I'와 'O'가 교대로 나오는 문자열
        int M = Integer.parseInt(br.readLine()); // 문자열 S의 길이

        char[] S = br.readLine().toCharArray(); // 'I'와 'O' 로만 이루어진 문자열
        int[] m = new int[M];

        int answer = 0;

        for(int i=1; i<M-1; i++){
            // 'OI'가 반복되는지 확인
            if(S[i]=='O' && S[i+1]=='I'){
                m[i+1] = m[i-1] + 1;

                // OI의 개수를 파악하고 OI가 반복되기 전에 'I'가 있으면
                if(m[i+1]>=N && S[i-2*N+1]=='I')
                    // count
                    answer++;
            }
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }

}


