import java.io.*;
import java.util.*;


/*   Baekjoon 5014번 - 스타트링크 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 15
*    메모리 : 58428 KB
*    시간 : 216 ms
 */


public class Main {
    private static int F, S, G, U, D;
    private static int[] visited; // 버튼을 누른 횟수 저장
    private static boolean[] checked; // 방문 표시
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 가장 높은 층
        S = Integer.parseInt(st.nextToken()); // 현재 위치
        G = Integer.parseInt(st.nextToken()); // 목표 위치
        U = Integer.parseInt(st.nextToken()); // 위로 U층
        D = Integer.parseInt(st.nextToken()); // 아래로 D층

        visited = new int[F+1];
        checked = new boolean[F+1];

        bfs(S);

        br.close();
    }
    // BFS 탐색
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = 0; // 초기 값
        checked[start] = true; 

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(cur==G){ // 목표 위치에 도달했으면 출력
                System.out.println(visited[G]);
                return;
            }

            // 현재 위치에서 U 층 위로 갈 수 있고 체크하지 않았다면
            if(cur+U <= F && !checked[cur+U]) {
                checked[cur+U] = true; // 체크 표시
                queue.add(cur+U); // 다음에 이동할 위치를 저장
                visited[cur+U] = visited[cur] + 1; // 현재 위치 + 1
            }

            // 현재 위치에서 D 층 밑으로 갈 수 있고 체크하지 않았다면
            if(cur-D >= 1 && !checked[cur-D]) {
                checked[cur-D] = true;
                queue.add(cur-D); 
                visited[cur-D] = visited[cur] + 1;
            }
        }
        // 목표 위치에 도달하지 못하여 while 문을 벗어났으면 출력
        System.out.println("use the stairs");
    }
}


