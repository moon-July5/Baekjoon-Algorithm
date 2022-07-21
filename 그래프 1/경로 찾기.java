import java.io.*;
import java.util.StringTokenizer;

/*   Baekjoon 11403번 - 경로 찾기 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 21
*    메모리 : 17388 KB
*    시간 : 224 ms
 */

public class Main {
    private static int N; // 정점의 개수
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 와샬
        for(int k=0; k<N; k++){ // 거쳐가는 노드
            for(int i=0; i<N; i++){ // 시작 노드
                for(int j=0; j<N; j++){ // 도착 노드
                    if(arr[i][k]==1 && arr[k][j]==1){
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(arr[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }


}

