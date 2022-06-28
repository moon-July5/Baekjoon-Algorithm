import java.io.*;
import java.util.*;

/*   Baekjoon 13549번 - 숨바꼭질 3 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 06 - 28
*    메모리 : 87220 KB
*    시간 : 260 ms
 */
public class Main {
    private static int N, K;    // 수빈이와 동생의 위치
    private static boolean[] visited = new boolean[100001]; // 방문 표시
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
    // BFS 방식
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});    // 현재 위치, 걸리는 시간

        while (!queue.isEmpty()){
            int[] node = queue.poll();

            // 현재 위치 방문 표시
            visited[node[0]] = true;

            if(node[0]==K) {answer = Math.min(answer, node[1]);}

            // 문제에서 현재위치 * 2는 0초 걸린다고 되어있기 때문에 걸리는 시간을 추가하지 않는다.
            if(node[0]*2<=100000 && !visited[node[0]*2]){
                queue.add(new int[] {node[0]*2, node[1]});
            }
            if(node[0]+1<=100000 && !visited[node[0]+1]){
                queue.add(new int[] {node[0]+1, node[1]+1});
            }
            if(node[0]-1>=0 && !visited[node[0]-1]){
                queue.add(new int[] {node[0]-1, node[1]+1});
            }
        }
    }

}

