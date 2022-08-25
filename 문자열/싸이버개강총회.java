import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


/*   Baekjoon 19583번 - 싸이버개강총회 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 25
*    메모리 : 60572 KB
*    시간 : 672 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken(); // 개강총회를 시작한 시간
        String E = st.nextToken(); // 개강총회가 끝나는 시간
        String Q = st.nextToken(); // 개강총회 스트리밍을 끝낸 시간

        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();

        int answer = 0;
        String str = null;

        while (!(str = br.readLine()).equals("")){
            String[] temp = str.split(" ");

            if(S.compareTo(temp[0])>=0) // 개강총회를 시작하기전에 입장했으면
                start.add(temp[1]);
            else if(E.compareTo(temp[0])<=0 && Q.compareTo(temp[0])>=0) // 개강총회가 끝나고 스트리밍이 끝난 시간 전에 채팅 친 경우
                end.add(temp[1]);
        }

        // 개강총회를 시작하고 나서 채팅친 경우에서
        for(String name : start){
            // 개강총회가 끝나고 나서 스프리밍이 끝난 시간전에 채팅친 경우 count 
            if(end.contains(name))
                answer++;
        }
        bw.write(answer+"");

        bw.close();
        br.close();
    }

}


