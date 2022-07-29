import java.io.*;
import java.util.*;

/*   Baekjoon 13567번 - 로봇 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 07 - 29
*    메모리 : 16300 KB
*    시간 : 172 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 정사각형 S의 한 변의 길이
        int N = Integer.parseInt(st.nextToken()); // 로봇이 수행할 명령어의 개수

        int x=0, y=0, dir=0; // x축, y축 좌표, 방향 좌표(0: 동쪽, 1: 북쪽, 2: 서쪽, 3: 남쪽)

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken(); // 명령어
            int value = Integer.parseInt(st.nextToken()); // 동작과 관련된 값

            if(command.equals("MOVE")){
                if(dir==0) x += value; // 동쪽으로 이동
                else if(dir==1) y += value; // 북쪽으로 이동
                else if(dir==2) x -= value; // 서쪽으로 이동
                else if(dir==3) y -= value; // 남쪽으로 이동
            } else if(command.equals("TURN")){
                if(value==0) { // 왼쪽으로 90도 회전 명령
                    dir++; // 방향 좌표를 바꿈
                    if (dir>3) dir=0; // 방향 좌표가 3보다 클 경우 0으로 초기화하여 동쪽으로 이동하도록 함
                }
                else { // 오른쪽으로 90도 회전 명령
                    dir--;
                    if (dir<0) dir=3; // 방향 좌표가 0보다 작을 경우 3으로 초기화하여 남쪽으로 이동하도록 함
                }
            }

            // 명령어 열이 유효하지 않을 경우 ( 좌표 범위를 넘어서면 )
            if(x<0 || y<0 || x>M || y>M){
                System.out.println(-1);
                System.exit(0);
            }
        }

        bw.write(x+" "+y);
        bw.flush();

        bw.close();
        br.close();
    }

}

