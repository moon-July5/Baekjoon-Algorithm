import java.io.*;
import java.util.*;

/*   Baekjoon 1347번 - 미로 만들기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 01
*    메모리 : 14380 KB
*    시간 : 132 ms
 */

public class Main {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 홍준이가 적은 내용의 길이

        String text = br.readLine(); // 홍준이가 적은 내용


        char[][] map  = new char[101][101]; // 미로를 나타내는 배열

        // 미로를 나타내는 배열 map에 벽(#)으로 채운다.
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                map[i][j] = '#';
            }
        }

        int startX, startY, minY, minX, maxY, maxX;
        startX = startY = minY = minX = maxX = maxY = 50;

        int dir = 2; // 방향을 나타내는 변수

        map[startY][startX] = '.';

        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == 'F'){ // 앞으로 한 칸
                startX += dx[dir];
                startY += dy[dir];

                map[startY][startX] = '.';

                // 전체 (100, 100) 크기에서 이동한 구역만 출력하기 위해 
                maxX = Math.max(maxX, startX);
                minX = Math.min(minX, startX);
                maxY = Math.max(maxY, startY);
                minY = Math.min(minY, startY);
            } else if(text.charAt(i) == 'L'){ // 왼쪽으로 90도 회전
                dir -= 1;
                if(dir==-1) dir = 3;
            } else if(text.charAt(i) == 'R'){ // 오른쪽으로 90도 회전
                dir = (dir + 1) % 4;
            }
        }

        // 출력
        for(int i=minY; i<=maxY; i++){
            for(int j=minX; j<=maxX; j++){
                bw.write(map[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }


}

