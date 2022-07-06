import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/*   Baekjoon 15666번 - N과 M (12) (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 07 - 06
*    메모리 : 25352 KB
*    시간 : 316 ms
 */

public class Main {
    private static int N, M;
    private static int[] arr; // N개의 수를 저장할 배열
    private static int[] arr2; // M개의 수를 저장할 배열
    private static HashSet<String> hashSet = new LinkedHashSet<>(); // 삽입한 순서대로 정렬을 위해, 그리고 중복된 요소를 배제하기 위해
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 출력하기 위해 정렬
        Arrays.sort(arr);

        dfs(0,0);

        // hashSet 에 저장된 수열을 출력
        hashSet.forEach(System.out::println);

        bw.close();
        br.close();
    }

    public static void dfs(int n, int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int val : arr2){
                sb.append(val).append(' ');
            }
            // 중복되는 수열을 배제
            hashSet.add(sb.toString());
            return;
        }

        /*
            같은 수를 여러 번 사용하고 수열이 비내림차순이여야 하기 때문에
            for 문 안에 i의 초기 값을 변수 n으로 설정하고 재귀 호출을 통해 i 값을 지정한다. 
         */
        for(int i=n; i<N; i++){
            arr2[depth] = arr[i];
            dfs(i, depth+1);
        }
    }
}

