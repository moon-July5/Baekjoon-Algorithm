import java.io.*;
import java.util.*;


/*   Baekjoon 2210번 - 숫자판 점프 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 09
*    메모리 : 17080 KB
*    시간 : 164 ms
 */

public class Main {
    private static int[][] arr; // 숫자들을 저장할 배열
    private static HashSet<String> hashSet = new HashSet<>(); // 숫자들의 조합을 중복되지 않게 저장
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1 ,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[5][5];

        // 숫자 입력
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(i, j, String.valueOf(arr[i][j]), 0);
            }
        }

        // 숫자들이 중복되지 않게 저장된 hashset의 사이즈 출력
        bw.write(hashSet.size()+"");
        bw.flush();

        bw.close();
        br.close();
    }
    // DFS 방식
    public static void dfs(int a, int b, String str, int depth){
        if(depth == 5){ // depth가 5인 경우는 숫자들의 조합이 6개가 되었다는 의미
            hashSet.add(str); // 중복되지 않게 저장
            return;
        }

        // 인접한 4 방향 탐색
        for(int i=0; i<4; i++){
            int x = a + dx[i];
            int y = b + dy[i];

            // 탐색하는 범위를 넘어서지 않게
            if(x>=0 && y>=0 && x<5 && y<5){
                // 재귀호출
                dfs(x, y, str+String.valueOf(arr[x][y]), depth+1);
            }
        }
    }


}

