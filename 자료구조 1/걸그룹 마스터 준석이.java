import java.io.*;
import java.util.*;

/*   Baekjoon 16165번 - 걸그룹 마스터 준석이 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 01
*    메모리 : 14388 KB
*    시간 : 128 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 걸그룹의 수
        int K = Integer.parseInt(st.nextToken()); // 맞혀야 할 문제의 수

        TreeMap<String, String> treeMap = new TreeMap<>();

        // 걸그룹 정보 입력
        for(int i=0; i<N; i++){
            String groupName = br.readLine(); // 그룹 이름
            int number = Integer.parseInt(br.readLine()); // 그룹 인원

            for(int j=0; j<number; j++){
                treeMap.put(br.readLine(), groupName); // (멤버 이름, 그룹 이름) 형태로 저장
            }
        }

        // 문제 입력
        for(int i=0; i<K; i++){
            String name = br.readLine(); // 그룹의 이름이나 멤버 이름
            int q = Integer.parseInt(br.readLine()); // 퀴즈의 종류

            if(q==0){ // 그룹 이름이 주어지며, 그룹의 멤버들을 모두 출력
               for(Map.Entry<String, String> entry : treeMap.entrySet()){
                   if(entry.getValue().equals(name)) // 그룹 이름과 같은 value 값이면
                       bw.write(entry.getKey()+"\n"); // key 값 출력 
               }
            } else { // 그룹의 멤버가 주어지며, 그룹 이름을 출력
                bw.write(treeMap.get(name)+"\n");
            }

        }
        bw.close();
        br.close();
    }
}



