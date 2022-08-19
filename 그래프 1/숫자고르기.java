import java.io.*;
import java.util.*;


/*   Baekjoon 2668번 - 숫자고르기 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 19
*    메모리 : 14648 KB
*    시간 : 144 ms
 */ 

public class Main {
    private static int N; // 정수
    private static boolean[] visited; // 방문 표시
    private static int[] arr;
    private static ArrayList<Integer> list; // 사이클이 발생한 수들을 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        visited = new boolean[N+1];

        // 입력
        for(int i=1; i<=N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        // DFS 탐색
        for (int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, i);
                visited[i] = false;
            }
        }

        Collections.sort(list); // 오름차순으로 정렬

        bw.write(list.size()+"\n"); // 뽑힌 정수들의 개수 출력

        // 뽑힌 정수들을 오름차순으로 출력
        for(int val : list)
            bw.write(val+"\n");

        bw.close();
        br.close();
    }
    // DFS 탐색
    public static void dfs(int start, int target){
        if(arr[start] == target) { list.add(target); } // 사이클이 발생하게 되면 해당 수를 저장

        if(!visited[arr[start]]){ // 방문하지 않았다면
            visited[arr[start]] = true; // 방문 표시
            dfs(arr[start], target);
            visited[arr[start]] = false; // 미방문 표시
        }
    }
}


