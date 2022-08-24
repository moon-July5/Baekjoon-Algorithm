import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/*   Baekjoon 4358번 - 생태학 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 24
*    메모리 : 84796 KB
*    시간 : 948 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        int count = 0;

        while(true){
            String tree = br.readLine(); // 나무 종 이름 입력

            if(tree==null || tree.length()==0) break;

            count++; // 나무의 개수

            treeMap.put(tree, treeMap.getOrDefault(tree, 0)+1); // (나무 종 이름, 개수) 형태로 저장
        }

        for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
            double value = (double) (entry.getValue() * 100.0) / count; // 각 나무의 종이 전체에서 몇 %를 차지하는지
            bw.write(entry.getKey() +" "+String.format("%.4f",value)+"\n"); // 소수점 4째자리까지 반올림
        }
        bw.flush();

        bw.close();
        br.close();
    }

}


