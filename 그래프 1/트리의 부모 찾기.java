import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*   Baekjoon 11725번 - 트리의 부모 찾기 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 08
*    메모리 : 79520 KB
*    시간 : 824 ms
 */
public class Main {
    private static int N; // 노드의 개수
    private static int[] parent; // 부모 노드를 나타내는 배열
    private static boolean[] visited; // 방문 표시
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 루트 노드 1 삽입

        visited[1] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();

            // 인접한 노드를 꺼낸다
            for(int next : list.get(node)){
                // 인접한 노드에 방문하지 않았다면
                if(!visited[next]){
                    visited[next] = true; // 방문 표시
                    parent[next] = node; // 부모를 나타내는 배열에 값 갱신
                    queue.add(next); // 큐 삽입
                }
            }
        }

        for(int i=2; i<=N; i++)
            bw.write(parent[i]+"\n");

        bw.flush();

        bw.close();
        br.close();
    }
}

