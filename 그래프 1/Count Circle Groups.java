import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


/*   Baekjoon 10216번 - Count Circle Groups (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 24
*    메모리 : 156388 KB
*    시간 : 6172 ms
 */
class Circle {
    int x, y, r;

    public Circle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
public class Main {
    private static int N; // 적군 진영의 숫자
    private static int[] parent; // 부모 노드 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());

            Circle[] circles = new Circle[N];
            parent = new int[N];

            // 적군 진영의 좌표 입력
            for(int n=0; n<N; n++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                circles[n] = new Circle(x, y, r);
            }

            // 부모 노드 초기값
            for(int i=0; i<N; i++)
                parent[i] = i;

            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    Circle c1 = circles[i];
                    Circle c2 = circles[j];

                    // 서로 같은 집합이면
                    if(find(i) == find(j)) continue;

                    int r = (int) Math.pow(c1.r+c2.r, 2);
                    int dis = (int) (Math.pow(c1.x-c2.x, 2) + Math.pow(c1.y-c2.y, 2));

                    if(r >= dis) union(i, j);
                }
            }

            Set<Integer> set = new HashSet<>();

            for(int num : parent)
                set.add(find(num));

            bw.write(set.size()+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
    // Union - Find Algorithm
    // union - x와 y가 속한 그룹을 하나로 합침
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        parent[y] = x;
    }

    // find - x가 속한 부모 노드를 반환
    public static int find(int x){
        if(x==parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

}


