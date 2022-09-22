import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 1080번 - 행렬 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 22
*    메모리 : 44416 KB
*    시간 : 328 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        int[][] matrixA = new int[N][M];
        int[][] matrixB = new int[N][M];

        // 행렬 A 입력
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                matrixA[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        // 행렬 B 입력
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                matrixB[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        int answer = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // A 행렬과 B 행렬의 각 요소를 비교하여 같지않으면, 3X3 크기의 부분 행렬을 반전시키기 위해 범위를 넘지 않아야 한다.
                if(matrixA[i][j]!=matrixB[i][j] && i+2<N && j+2<M){
                    // 3X3 크기의 부분 행렬을 반전시킨다.
                    for(int r=i; r<i+3; r++){
                        for(int c=j; c<j+3; c++){
                            matrixA[r][c] = matrixA[r][c]==1 ? 0 : 1;
                        }
                    }
                    // 반전시켰으면 연산 횟수 count
                    answer++;
                }
            }
        }

        // 다시 한번 A 행렬과 B 행렬이 같은지 확인. 같지 않은 것을 발견하면 -1 출력 후 종료
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrixA[i][j] != matrixB[i][j]){
                    bw.write(-1+"");
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}



