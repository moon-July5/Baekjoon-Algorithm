import java.io.*;
import java.util.*;

/*   Baekjoon 14713번 - 앵무새 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 03
*    메모리 : 23304 KB
*    시간 : 372 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 앵무새의 수

        Queue[] queue = new Queue[N];

        for(int i=0; i<N; i++){
            queue[i] = new LinkedList();
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 각 문장을 큐에 저장
            while(st.hasMoreTokens())
                queue[i].add(st.nextToken());
        }

        //  cseteram이 받아 적은 문장 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean flag = true; // 가능한 문장 판별

        while(st.hasMoreTokens()){
            boolean check = false; 

            String word = st.nextToken(); // 받아 적은 문장을 단어로 쪼갬

            for(int i=0; i<N; i++){
                // 앵무새가 말한 각 문장이 비어있지 않고
                if(!queue[i].isEmpty()){
                    // 앵무새가 말한 문장의 단어와 받아 적은 문장의 단어와 같다면
                    if(queue[i].peek().equals(word)){
                        // 삭제
                        queue[i].poll();
                        // 가능한 단어라고 판별
                        check = true;
                        break;
                    }
                }
            }

            // 불가능한 단어라고 판별될 경우 
            if(!check) {
                // flag를 false로 갱신하여 "Impossible"로 유도
                flag = false;
                break;
            }
        }

        // 또 다른 경우는 큐가 비어있지 않는 것도 "Impossible"로 판별
        for(int i=0; i<N; i++){
            if(!queue[i].isEmpty()) flag = false;
        }

        // flag가 false면 "Impossible"
        if(!flag) bw.write("Impossible");
        else bw.write("Possible");

        bw.flush();

        bw.close();
        br.close();
    }
}



