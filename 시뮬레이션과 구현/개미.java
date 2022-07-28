import java.io.*;
import java.util.*;

/*   Baekjoon 3048번 - 개미 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 07 - 28
*    메모리 : 14276 KB
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken()); // 첫 번째 그룹의 개미 수
        int N2 = Integer.parseInt(st.nextToken()); // 두 번째 그룹의 개미 수

        String g1 = br.readLine(); // 첫 번째 그룹
        char[] ch1 = new char[N1];

        for(int i=0; i<N1; i++)
            ch1[i] = g1.charAt(N1-i-1); // 뒤집어서 저장

        char[] ch2 = br.readLine().toCharArray(); // 두 번째 그룹

        int T = Integer.parseInt(br.readLine());

        char[] ants = new char[N1+N2]; // 첫 번째, 두 번쨰 그룹을 합칠 배열
        int[] group = new int[N1+N2]; // 그룹 배열

        // 첫 번째 그룹을 ants 배열에 저장
        for(int i=0; i<N1; i++){
            ants[i] = ch1[i];
            group[i] = 1;
        }

        // 두 번째 그룹을 ants 배열에 저장
        for(int i=N1; i<N1+N2; i++){
            ants[i] = ch2[i-N1];
            group[i] = 2;
        }

        for(int t=0; t<T; t++){
            for(int i=0; i<N1+N2-1; i++){
                if(group[i]==1 && group[i+1]==2){ // 같은 그룹이 아니면
                    swap(ants, i, i+1); // 두 개미를 바꾼다.

                    // 그룹 배열 또한 바꿔준다.
                    int temp = group[i];
                    group[i] = group[i+1];
                    group[i+1] = temp;

                    i++; // 바뀐 개미들이 다시 바뀌지 않게 i++를 해준다.
                }
            }
        }

        for(char c : ants)
            bw.write(c+"");

        bw.flush();

        bw.close();
        br.close();
    }
    // 두 개미의 자리를 바꿔줄 메서드
    public static void swap(char[] ch, int a, int b){
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
    }
}

