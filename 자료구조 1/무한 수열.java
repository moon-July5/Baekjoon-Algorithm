import java.io.*;
import java.util.*;

/*   Baekjoon 1351번 - 무한 수열 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 09 - 06
*    메모리 : 14344 KB
*    시간 : 132 ms
 */

public class Main {
    private static Map<Long, Long> map = new HashMap<>();
    private static int P, Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        bw.write(solve(N)+"");

        bw.close();
        br.close();
    } 

    /*
        문제의 범위가 너무 크기 때문에 DP의 메모이제이션을 이용해서 풀 경우 공간 초과 오류가 날 수 있다.
        Map<Long, Long>을 이용할 경우 범위가 정해져 있지 않아 범위 초과 문제 없이 공간 활용도를 높일 수 있다.
     */
    public static long solve(long n){
        if(n==0) return 1; // 문제에서 주어진 대로 0일 경우 1 반환
        if(map.containsKey(n)) return map.get(n);

        long x = (long) Math.floor(n/P);
        long y = (long) Math.floor(n/Q);

        map.put(n, solve(x) + solve(y));
        return map.get(n);
    }
}



