import java.io.*;
import java.util.*;

/*   Baekjoon 16918번 - 봄버맨 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 04
*    메모리 : 21264 KB
*    시간 : 360 ms
 */
public class Main {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 행
        int C = Integer.parseInt(st.nextToken()); // 열
        int N = Integer.parseInt(st.nextToken()); // 시간

        char[][] map = new char[R][C];
        int[][] bombTime = new int[R][C];

        // 격자판의 초기 상태
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'O')
                    bombTime[i][j] = 3; // 폭탄이 터질 시간 (놓인 시간 + 3)
            }
        }

        int time = 0;

        while(time++ < N){
            // 비어있는 모든 칸에 폭탄 설치
            if(time % 2 == 0){
                for(int i=0; i<R; i++){
                    for(int j=0; j<C; j++){
                        if(map[i][j] == '.'){
                            map[i][j] = 'O';
                            bombTime[i][j] = time + 3;
                        }
                    }
                }
            } else if(time % 2 == 1){ // 터질 시간이 된 폭탄을 터뜨림

                for(int i=0; i<R; i++){
                    for(int j=0; j<C; j++){
                        if(bombTime[i][j] == time){
                            map[i][j] = '.';

                            for(int k=0; k<4; k++){
                                int y = i + dy[k];
                                int x = j + dx[k];

                                // 격자판의 크기 안에만 이동할 수 있으며,
                                if(y>=0 && x>=0 && y<R && x<C){
                                    // 터뜨려야 할 폭탄이 연쇄반응으로 미리 터뜨리게 되면,
                                    // 미리 터뜨린 폭탄의 주변 연쇄반응을 일으킬 수 없기 때문에 time을 확인한다.
                                    if(map[y][x] == 'O' && bombTime[y][x] != time){
                                        map[y][x] = '.';
                                        bombTime[y][x] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 출력
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

}

