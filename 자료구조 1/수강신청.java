import java.io.*;
import java.util.*;

/*   Baekjoon 13414번 - 수강신청 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 01
*    메모리 : 67372 KB
*    시간 : 784 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 수강 가능한 인원의 수
        int L = Integer.parseInt(st.nextToken()); // 대기목록의 길이

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for(int i=0; i<L; i++){
            // 학번 입력
            String studentId = br.readLine();

            // 같은 학번이 대기목록에 있으면 삭제
            if(set.contains(studentId)) set.remove(studentId);

            // 학번을 대기목록에 삽입
            set.add(studentId);
        }

        for(String str : set){
            if(K<=0) break;
            bw.write(str+"\n");
            K--;
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



