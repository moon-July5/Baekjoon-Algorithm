import java.io.*;

/*   Baekjoon 3085번 - 사탕게임 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 07 - 04
*    메모리 : 14444 KB
*    시간 : 208 ms
 */

public class Main {
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 보드의 크기

        char[][] arr = new char[N][N];

        // 보드에 채워져 있는 사탕의 색상
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        // 가로로 인접한 사탕과 교환하여 먹을 수 있는 사탕의 최대 개수를 탐색
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                swap(i, j, i, j+1, arr); // 두 사탕을 교환

                check(N, arr);  // 가로, 세로 비교하여 확인

                swap(i, j, i, j+1, arr); // 교환된 두 사탕을 복구
            }
        }

        // 세로로 인접한 사탕과 교환하여 먹을 수 있는 사탕의 최대 개수를 탐색
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N; j++){
                swap(i, j, i+1, j, arr);

                check(N, arr);

                swap(i, j, i+1, j, arr);
            }
        }

        bw.write(max+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // 두 사탕을 교환
    public static void swap(int x1, int y1, int x2, int y2, char[][] arr){
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    // 가로, 세로 비교하면서 먹을 수 있는 사탕의 최대 개수 확인
    public static void check(int N, char[][] arr) {
        // 가로 확인
        for(int i=0; i<N; i++){
            int count = 1;
            for(int j=0; j<N-1; j++){
                // 다음 사탕과 색이 같다면 count
                if(arr[i][j] == arr[i][j+1])
                    count++;
                else
                    count = 1; // 색이 같지 않다면 초기화

                max = Math.max(max, count);

            }
        }

        // 세로 확인
        for(int i=0; i<N; i++){
            int count = 1;
            for(int j=0; j<N-1; j++){
                if(arr[j][i] == arr[j+1][i])
                    count++;
                else
                    count = 1;

                max = Math.max(max, count);
            }
        }
    }

}

