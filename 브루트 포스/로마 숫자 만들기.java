import java.io.*;

/*   Baekjoon 16922번 - 로마 숫자 만들기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 11
*    메모리 : 14208 KB
*    시간 : 128 ms
 */

public class Main {
    private static int N; // 사용할 수 있는 문자의 개수
    private static boolean[] visited; // 방문 표시
    private static int[] values = {1, 5, 10, 50}; // 로마 숫자
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); 

        visited = new boolean[1001]; // 로마 숫자 중에 가장 큰 50을 N의 최대 범위를 곱한 값을 크기로 설정

        solve(0, 0, 0);

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void solve(int depth, int idx, int sum){
        if(depth == N){ // 문자의 개수를 모두 사용했으고
            if(!visited[sum]){ // 조합한 문자의 덧셈 인덱스를 방문하지 않았다면
                visited[sum] = true; // 방문 표시
                answer++; // 정답 개수 count
            }
            return;
        }
        
        for(int i=idx; i<4; i++){ // 로마 숫자의 개수 만큼 반복
            solve(depth+1, i, sum+values[i]); // sum에 로마 숫자를 더하면서 조합
        }
    }
}



