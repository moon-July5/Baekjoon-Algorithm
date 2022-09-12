import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 2615번 - 오목 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 12
*    메모리 : 16100 KB
*    시간 : 160 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[19][19];

        int[][] dir = {{0,1}, {1,0}, {1,1}, {-1,1}}; // 방향

        // 바둑알 입력
        for(int i=0; i<19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 바둑알 탐색
        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                if(arr[j][i]==1 || arr[j][i]==2){ // 바둑알이 검은색인지 흰색인지 판별
                    for(int d=0; d<4; d++){
                        int x = j;
                        int y = i;
                        int count = 1; // 같은색의 바둑알 개수

                        // 증가하는 방향 탐색
                        while (true){
                            x += dir[d][0];
                            y += dir[d][1];

                            if(x>=0 && y>=0 && x<19 && y<19){ // 바둑판의 범위안에 있어야 하고
                                if(arr[j][i] == arr[x][y]) count++; // 같은색이면 count
                                else break;
                            } else break;

                        }

                        x = j;
                        y = i;

                        // 증가하는 방향의 반대 방향 탐색
                        while (true){
                            x -= dir[d][0];
                            y -= dir[d][1];

                            if(x>=0 && y>=0 && x<19 && y<19){ // 바둑판의 범위안에 있어야 하고
                                if(arr[j][i] == arr[x][y]) count++; // 같은색이면 count
                                else break;
                            } else break;
                        }

                        if(count==5){ // 같은색이 5개이면 이김
                            bw.write(arr[j][i]+"\n"); // 어떤 색이 이겼는지 출력
                            bw.write((j+1)+" "+(i+1)); // 위치 출력, 이중 for 문으로 인해 항상 가장 왼쪽 위의 좌표를 출력
                            bw.flush();
                            return;
                        }
                    }
                }
            }
        }

        // 아무도 못 이겼을 경우
        bw.write(0+"");

        bw.close();
        br.close();
    }
}



