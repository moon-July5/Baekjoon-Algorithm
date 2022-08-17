import java.io.*;
import java.util.*;


/*   Baekjoon 1764번 - 듣보잡 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 08 - 17
*    메모리 : 26736 KB
*    시간 : 332 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수

        HashSet<String> hashSet = new HashSet<>(); // 듣도 못한 사람을 저정할 공간
        ArrayList<String> answer = new ArrayList<>(); // 듣도 보도 못한 사람을 저장할 공간

        // 듣도 못한 사람 입력
        for(int i=0; i<N; i++){
            hashSet.add(br.readLine());
        }

        // 보도 못한 사람 입력
        for(int i=0; i<M; i++){
            String s = br.readLine();

            if(hashSet.contains(s)) answer.add(s);
        }

        Collections.sort(answer); // 사전순 정렬

        bw.write(answer.size()+"\n"); // 듣도 보도 못한 사람의 수 출력

        for(String s : answer)
            bw.write(s+"\n"); // 듣도 보도 못한 사람 출력

        bw.close();
        br.close();
    }

}


