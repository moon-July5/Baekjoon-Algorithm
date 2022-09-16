import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 16987번 - 계란으로 계란치기 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 16
*    메모리 : 16136 KB
*    시간 : 216 ms
 */

public class Main {
    private static int N; // 계란의 개수
    private static int[][] arr; // 계란의 내구도, 무게 저장
    private static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        // 계란의 정보 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 계란의 내구도
            int w = Integer.parseInt(st.nextToken()); // 계란의 무게

            arr[i][0] = s;
            arr[i][1] = w;
        }

        solve(0, 0);

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void solve(int depth, int count){
        if(depth == N){ // 마지막 계란까지 들었으면
            answer = Math.max(answer, count); // 최댓값 갱신
            return;
        }

        if(arr[depth][0]<=0 || count==N-1){ // 들고있는 계란이 깨졌거나 모든 계란이 깨져있다면
            solve(depth+1, count); // 다음 계란
            return;
        }

        int temp = count;

        for(int i=0; i<N; i++){
            if(depth != i && arr[i][0]>0){ // 들고있는 계란과 깨뜨릴 계란과 달라야하고 깨뜨릴 계란이 내구도가 0보다 커야한다.
                hit(depth, i); // 계란으로 계란을 친다.
                if(arr[depth][0]<=0) count++; // 들고있는 계란이 깨질 경우
                if(arr[i][0]<=0) count++; // 들고있는 계란으로 다음 계란을 깨뜨릴 경우

                solve(depth+1, count);

                recovery(depth, i); // 다른 조합을 찾기 위해 복구
                count = temp;
            }
        }
    }

    // 손에 들고 있는 계란으로 다른 계란 치는 행동
    public static void hit(int hand, int target){
        arr[target][0] -= arr[hand][1];
        arr[hand][0] -= arr[target][1];
    }

    // 다른 조합을 찾기위해 복구
    public static void recovery(int hand, int target){
        arr[target][0] += arr[hand][1];
        arr[hand][0] += arr[target][1];
    }
}



