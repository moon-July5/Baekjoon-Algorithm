import java.io.*;
import java.util.*;

/*   Baekjoon 17204번 - 죽음의 게임 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 01
*    메모리 : 14236 KB
*    시간 : 128 ms
 */

public class Main {
    private static int N, K;
    private static int[] arr; // 지목하는 사람의 번호들을 저장
    private static boolean[] visited; // 방문 표시
    private static int count = 0, next=0, flag=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        K = Integer.parseInt(st.nextToken()); // 보성이의 번호

        arr = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        while(true){
            // 보성이의 번호와 같다면
            if(arr[next]==K){
                count++;
                break;
            }

            // 사람들 사이에서 사이클이 생겼다는 의미 (지목했던 학생이 다시 지목한다면)
            if(visited[arr[next]]){
                flag = 1;
                break;
            } else {
                next = arr[next]; // 다음 지목
                visited[next] = true; // 방문 표시
                count++;
            }
        }

        if(flag==1) bw.write(-1+"");
        else bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }

}

