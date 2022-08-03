import java.io.*;
import java.util.*;

/*   Baekjoon 5212번 - 지구 온난화 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 03
*    메모리 : 14308 KB
*    시간 : 128 ms
 */
public class Main {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 세로 크기
        int C = Integer.parseInt(st.nextToken()); // 가로 크기

        char[][] map = new char[R][C];
        char[][] temp = new char[R][C];

        // 지도 입력
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
                temp[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 'X'){ // 땅일 경우
                    int count = 0;

                    // 4 방향 탐색
                    for(int k=0; k<4; k++){
                        int x = i + dx[k];
                        int y = j + dy[k];

                        // 인접한 곳 탐색 중 지도 크기의 범위 안에 있어야 하며
                        if(x>=0 && y>=0 && x<R && y<C){
                            // 인접한 곳이 바다라면
                            if(map[x][y] == '.') count++;
                        } else { // 지도 크기의 범위를 넘어서면 바다로 인식
                            count++;
                        }
                    }

                    // 인접한 세 칸 이상이 바다가 있는 땅은 모두 잠기기 때문에 바다로 변환
                    if(count>=3) temp[i][j] = '.';
                }
            }
        }

        // 최소한의 지도만 출력하기 위해
        int maxR = Integer.MIN_VALUE;
        int minR = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(temp[i][j] == 'X'){
                    maxR = Math.max(maxR, i);
                    minR = Math.min(minR, i);
                    maxC = Math.max(maxC, j);
                    minC = Math.min(minC, j);
                }
            }
        }

        // 결과 출력
        for(int i=minR; i<=maxR; i++){
            for(int j=minC; j<=maxC; j++){
                bw.write(temp[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

}

