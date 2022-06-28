import java.io.*;
import java.util.*;

/*   Baekjoon 1697번 - 숨바꼭질 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 28
*    메모리 : 18572 KB
*    시간 : 160 ms
 */
public class Main {
    private static int N, K;    // 수빈이와 동생의 위치
    private static int[] visited = new int[100001];   // 방문한 곳에 이동한 값 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        bw.write(bfs(N)+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 방식
    public static int bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        visited[n] = 1; // 시작부분 1 저장

        while(!queue.isEmpty()){
            int node = queue.poll();

            // 동생의 위치에 이동했으면 값을 반환하고 종료
            if(node==K){
                return visited[node]-1;
            }

            // 현재위치 - 1 로 이동한 경우 방문한 적이 없어야 함
            if(node-1>=0 && visited[node-1]==0){
                visited[node-1] = visited[node]+1;
                queue.add(node-1);
            }
            // 현재위치 + 1 로 이동한 경우
            if(node+1<=100000 && visited[node+1]==0){
                visited[node+1] = visited[node]+1;
                queue.add(node+1);
            }
            // 현재위치 * 2 로 이동한 경우
            if(node*2<=100000 && visited[node*2]==0){
                visited[node*2] = visited[node]+1;
                queue.add(node*2);
            }
        }
        return -1;
    }




}

