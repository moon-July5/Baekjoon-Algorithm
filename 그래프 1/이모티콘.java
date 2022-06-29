import java.io.*;
import java.util.*;

/*   Baekjoon 14226번 - 이모티콘 (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 29
*    메모리 : 19228 KB
*    시간 : 136 ms
 */
public class Main {
    private static int S;   // 이모티콘 개수
    private static boolean[][] visited; // [화면 이모티콘 수][클립보드 이모티콘 수]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());

        visited = new boolean[2001][2001];

        bfs();

        br.close();
    }
    // BFS 방식
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        // 화면 이모티콘 수, 클리보드 이모티콘 수, 걸리는 시간
        queue.add(new int[] {1, 0, 0});

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            int emotion = node[0]; int clipboard = node[1]; int time = node[2];

            // 화면에 이모티콘 수가 S와 같다면
            if(emotion == S){
                System.out.println(time);
                return;
            }

            if(emotion>0 && emotion<2000){
                // 화면 이모티콘을 클립보드에 복사
                if(!visited[emotion][emotion]){
                    visited[emotion][emotion] = true;
                    queue.add(new int[] {emotion, emotion, time+1});
                }

                // 화면 이모티콘을 삭제
                if(!visited[emotion-1][clipboard]){
                    visited[emotion-1][clipboard] = true;
                    queue.add(new int[] {emotion-1, clipboard, time+1});
                }
            }

            // 클립보드에 있는 것을 붙여넣기
            if(clipboard>0 && emotion+clipboard<2000){
                if(!visited[emotion+clipboard][clipboard]){
                    visited[emotion+clipboard][clipboard] = true;
                    queue.add(new int[] {emotion+clipboard, clipboard, time+1});
                }
            }


        }
    }


}

