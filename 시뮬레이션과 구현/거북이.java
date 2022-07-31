import java.io.*;
import java.util.*;

/*   Baekjoon 8911번 - 거북이 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 31
*    메모리 : 26304 KB
*    시간 : 576 ms
 */

public class Main {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int minX, maxX, minY, maxY;
    private static int x, y, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t=0; t<T; t++){
            String command = br.readLine(); // 컨트롤 프로그램
            x = y = d = 0;
            minX = maxX = minY = maxY = 0;

            for(int i=0; i<command.length(); i++){
                if(command.charAt(i) == 'F'){ // 한 눈금 앞으로
                    x += dx[d];
                    y += dy[d];
                    calc();
                } else if(command.charAt(i) == 'B') { // 한 눈금 뒤로
                    x -= dx[d];
                    y -= dy[d];
                    calc();
                } else if(command.charAt(i) == 'L') { // 왼쪽으로 90도 회전
                    d = d-1 == -1 ? 3 : d-1;
                } else if(command.charAt(i) == 'R') { // 오른쪽으로 90도 회전
                    d = d+1 == 4 ? 0 : d+1;
                }
            }

            bw.write(Math.abs(maxX - minX) * Math.abs(maxY - minY)+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    public static void calc() {
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
    }
}

