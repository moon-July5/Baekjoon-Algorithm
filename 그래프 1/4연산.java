import java.io.*;
import java.util.*;

/*   Baekjoon 14395번 - 4연산 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 08 - 29
*    메모리 : 17892 KB
*    시간 : 204 ms
 */
class Node {
    long val;
    String s;

    public Node(long val, String s){
        this.val = val;
        this.s = s;
    }
}
public class Main {
    private static long S, T;
    private static HashSet<Long> hashSet = new HashSet<>(); // 연산 결과 값을 저장
    private static char[] cal = {'*', '+', '-', '/'}; // 4 연산
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        if(S==T) bw.write(0+"");
        else bfs();

        bw.close();
        br.close();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(S, ""));

        hashSet.add(S);

        while (!queue.isEmpty()){
            Node node = queue.poll();

            // 정수 S에서 T로 변환 성공했으면 연산 출력
            if(node.val == T) {
                System.out.println(node.s);
                return;
            }

            // 4연산 탐색(*, +, -, /)
            // 연산 방법이 여러가지라면 연산들을 사전순으로 출력하기 위해 아스키코드 순서대로 연산한다.
            for(int i=0; i<4; i++){
                long num = 0;

                switch (i){
                    case 0 :
                        num = node.val * node.val;
                        break;
                    case 1 :
                        num = node.val + node.val;
                        break;
                    case 2 :
                        num = node.val - node.val;
                        break;
                    case 3 :
                        if(node.val != 0){
                            num = node.val / node.val;
                            break;
                        }
                }

                // 연산결과 값이 중복되지 않았다면
                if(!hashSet.contains(num)){
                    hashSet.add(num); // hashset에 저장
                    queue.add(new Node(num, node.s+cal[i]));
                }
            }
        }
        System.out.println(-1);
        return;
    }
}


