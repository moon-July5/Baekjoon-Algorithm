import java.io.*;
import java.util.*;

/*   Baekjoon 1063번 - 킹 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 31
*    메모리 : 14296 KB
*    시간 : 144 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] king = st.nextToken().toCharArray(); // 킹의 위치
        char[] stone = st.nextToken().toCharArray(); // 돌의 위치
        int N = Integer.parseInt(st.nextToken()); // 움직이는 횟수

        for(int i=0; i<N; i++){
            String command = br.readLine();

            char[] nextKing = king.clone();
            char[] nextStone = stone.clone();

            move(command, nextKing); // 킹의 위치를 움직인다.

            if(range(nextKing)) continue; // 움직인 킹의 위치가 체스판 위를 벗어나면 움직임을 취소한다.

            if(Arrays.equals(nextKing, nextStone)){ // 이동한 킹과 돌의 위치가 같다면
                move(command, nextStone); // 돌의 위치를 움직인다.
                if(range(nextStone)) continue; // 움직인 돌의 위치가 체스판 위를 벗어나면 움직임을 취소한다.
            }

            king = nextKing;
            stone = nextStone;
        }
        // 킹의 위치 출력
        for(char c : king)
            bw.write(c);

        bw.write("\n");

        // 돌의 위치 출력
        for (char c : stone)
            bw.write(c);

        bw.flush();

        bw.close();
        br.close();
    }

    // 명령에 따라 이동한 킹이나 돌의 위치가 체스판 안에 있는지 확인
    public static boolean range(char[] next){
        return(next[0]<'A' || next[0]>'H' || next[1]<'1' || next[1]>'8');
    }

    // 명령의 따라 킹 또는 돌이 움직이는 메서드
    public static void move(String command, char[] next){
        if(command.equals("R")){ // 한 칸 오른쪽으로
            next[0]++;
        } else if(command.equals("L")){ // 한 칸 왼쪽으로
            next[0]--;
        } else if(command.equals("B")){ // 한 칸 아래로
            next[1]--;
        } else if(command.equals("T")){ // 한 칸 위로
            next[1]++;
        } else if(command.equals("RT")){ // 오른쪽 위 대각선으로
            next[0]++; next[1]++;
        } else if(command.equals("LT")){ // 왼쪽 위 대각선으로
            next[0]--; next[1]++;
        } else if(command.equals("RB")){ // 오른쪽 아래 대각선으로
            next[0]++; next[1]--;
        } else if(command.equals("LB")){ // 왼쪽 아래 대각선으로
            next[0]--; next[1]--;
        }
    }



}

