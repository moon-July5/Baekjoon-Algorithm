import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 19941번 - 햄버거 분배 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 20
*    메모리 : 14440 KB
*    시간 : 136 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 식탁의 길이
        int K = Integer.parseInt(st.nextToken()); // 햄버거를 선택할 수 있는 거리

        char[] position = br.readLine().toCharArray(); // 사람과 햄버거의 위치를 문자로 입력(P, H)
        boolean[] visited = new boolean[N]; // 사람이 햄버거를 먹었다는 의미

        int answer = 0;

        for(int i=0; i<N; i++){
            // 사람이면
            if(position[i]=='P'){
                // 햄버거를 탐색
                int start = Math.max(i-K, 0);
                int end = Math.min(i+K, N-1);

                // K범위 안에서 사람이 먹을 수 있는 햄버거 탐색
                for(int j=start; j<=end; j++){
                    // 햄버거를 발견했고 먹지 않은 것이라면
                    if(position[j]=='H' && !visited[j]){
                        // 햄버거를 먹었다고 표시
                        visited[j] = true;
                        // count
                        answer++;
                        break;
                    }
                }
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



