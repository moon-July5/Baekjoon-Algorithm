import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 1325번 - 효율적인 해킹 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 23
*    메모리 : 305840 KB
*    시간 : 8276 ms
 */

public class Main {
    private static int N, M; // 컴퓨터의 수, 컴퓨터 관계의 수
    private static ArrayList<Integer>[] list;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        arr = new int[N+1];

        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        int max = Integer.MIN_VALUE;

        for(int i=1; i<=N; i++)
            bfs(i);

        for(int i=1; i<=N; i++)
            max = Math.max(max, arr[i]);

        for(int i=1; i<=N; i++){
            if(max == arr[i])
                bw.write(i+" ");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 탐색
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();

            for(int next : list[node]){
                if(!visited[next]){
                    visited[next] = true;
                    arr[next]++;
                    queue.add(next);
                }
            }
        }
    }
}

