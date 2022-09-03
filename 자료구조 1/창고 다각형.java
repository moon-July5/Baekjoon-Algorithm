import java.io.*;
import java.util.*;

/*   Baekjoon 2304번 - 창고 다각형 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 09 - 03
*    메모리 : 16140 KB
*    시간 : 160 ms
 */
class Column implements Comparable<Column>{
    int l, h; // 위치와 높이

    public Column(int l, int h){
        this.l = l;
        this.h = h;
    }

    @Override
    public int compareTo(Column o) {
        return this.l - o.l;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 기둥의 개수

        ArrayList<Column> list = new ArrayList<>();
        int answer = 0;

        int maxL = 0; // 가장 높이가 긴 기둥의 위치
        int maxK = 0; // 가장 높이간 긴 기둥의 값

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 기둥의 위치
            int K = Integer.parseInt(st.nextToken()); // 기둥의 높이

            list.add(new Column(L, K));

            // 가장 높이가 긴 기둥의 크기를 저장
            if(K>maxK) maxK = K;
        }

        // 기둥의 위치를 기준으로 오름차순으로 정렬
        Collections.sort(list);

        // 가장 높이가 긴 기둥의 위치를 탐색
        for(int i=0; i<list.size(); i++){
            if(list.get(i).h == maxK) {
                maxL = i;
                break;
            }
        }

        // 첫 기둥부터 가장 높이가 긴 기둥의 위치까지 탐색
        for(int i=0; i<maxL; i++){
            // 가장 높이가 긴 기둥이 여러개 일 수 있기 때문에 '='을 붙임
            for(int j=i+1; j<=maxL; j++){
                // 현재 기둥보다 긴 기둥을 발견했다면
                if(list.get(i).h <= list.get(j).h){
                    // 현재 기둥보다 긴 기둥 전까지 면적을 구한다.
                    answer += (list.get(j).l - list.get(i).l) * list.get(i).h;
                    // 현재 기둥보다 긴 기둥의 위치로 옮긴다.
                    i = j;
                }
            }
        }

        // 맨 마지막 기둥부터 가장 높이가 긴 기둥의 위치까지 탐색
        for(int i=N-1; i>maxL; i--){
            for(int j=i-1; j>=maxL; j--){
                // 앞에 위치한 기둥이 더 길다면
                if(list.get(i).h <= list.get(j).h){
                    // 앞에 위치한 기둥 전까지 면적을 구한다.
                    answer += (list.get(i).l - list.get(j).l) * list.get(i).h;
                    i = j;
                }
            }
        }

        // 지금까지 구한 면적 + 가장 긴 기둥의 값
        bw.write(answer + maxK + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}



