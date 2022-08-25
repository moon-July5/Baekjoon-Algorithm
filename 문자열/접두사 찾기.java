import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*   Baekjoon 14426번 - 접두사 찾기 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 25
*    메모리 : 70256 KB
*    시간 : 904 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N개의 문자열로 이루어진 집합
        int M = Integer.parseInt(st.nextToken()); // 검사해야하는 문자열

        ArrayList<String> list = new ArrayList<>();

        // 문자열 입력
        for(int i=0; i<N; i++)
            list.add(br.readLine());

        int answer = 0;

        // 검사해야 하는 문자열 입력
        for(int i=0; i<M; i++){
            String check = br.readLine();

            // 집합 S에 포함되어 있는 문자열을 하나씩 꺼내서 비교
            for(String str : list){
                // 집합 S의 문자열을 검사해야하는 문자열의 길이만큼 분할하고
                // 분할된 문자열이 일치하는 비교
                if(str.substring(0, check.length()).equals(check)){
                    // 일치하면 count
                    answer++;
                    break;
                }
            }
        }
        bw.write(answer+"");

        bw.close();
        br.close();
    }

}


