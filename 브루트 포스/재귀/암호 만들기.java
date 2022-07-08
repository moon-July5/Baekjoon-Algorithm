import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*   Baekjoon 1759번 - 암호 만들기 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 07 - 08
*    메모리 : 14296 KB
*    시간 : 128 ms
 */

public class Main {
    private static int L, C; // 암호의 문자 개수와 문자의 종류 개수
    private static char[] arr;
    private static char[] tArr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        tArr = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            arr[i] = st.nextToken().charAt(0);

        // 사전 순으로 출력하기 위해 오름차순으로 정렬
        Arrays.sort(arr);

        dfs(0, 0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int n, int depth){
        if(depth == L){
            // 암호에 모음 1개, 자음 2개 이상으로 이루어져 있어야 한다.
            if(isValid()) {
                for (char ch : tArr) {
                    sb.append(ch);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=n; i<C; i++){
            tArr[depth] = arr[i];
            dfs(i+1, depth+1);
        }
    }

    // 암호에 적어도 모음 한 글자, 자음 두 글자 이상으로 이루어져 있는지 판별
    public static boolean isValid(){
        int vo = 0; int co = 0; // 모음과 자음의 개수를 나타내는 변수

        for(char ch : tArr){
            // 모음일 경우
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') vo++;
            else co++;
        }

        // 모음 1개, 자음 2개 이상이면 true 반환
        if(vo>=1 && co>=2) return true;

        return false;
    }
}

