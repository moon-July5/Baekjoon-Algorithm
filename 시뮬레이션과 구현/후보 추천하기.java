import java.io.*;
import java.util.*;

/*   Baekjoon 1713번 - 후보 추천하기 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 02
*    메모리 : 15256 KB
*    시간 : 172 ms
 */
class People implements Comparable<People> {
    int idx;
    int number;
    int count;

    People(int idx, int number, int count){
        this.idx = idx;
        this.number = number;
        this.count = count;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(People o) {
        if(this.number < o.getNumber()) // 내림차순 정렬
            return -1;
        else if(this.number > o.getNumber()) // 오름차순 정렬
            return 1;

        return 0;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 사진틀의 개수
        int K = Integer.parseInt(br.readLine()); // 전체 학생의 총 추천 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<People> list = new ArrayList<>();

        boolean flag = true;
        int idx = 0;

        for(int i=0; i<K; i++){
            int number = Integer.parseInt(st.nextToken());

            // 사진틀에 사진이 있는 경우
            for(People p : list){
                if(p.number == number){
                    p.count++;
                    flag = false;
                    break;
                }
            }

            // 사진틀에 사진이 걸려있지 않은 경우
            if(flag){
                // 사진틀에 사진을 걸 수 있는 자리가 없는 경우
                if(list.size() == N){
                    // 점수가 다르면
                    Collections.sort(list, new Comparator<People>() {
                        @Override
                        public int compare(People o1, People o2) {
                            if(o1.count == o2.count) // 추천 수가 같다면
                                return o1.idx - o2.idx; // 오름차순 정렬(가장 오래된 사진을 삭제하기 위함)
                            else
                                return o1.count - o2.count; // 오름차순 정렬(가장 추천 수가 적은 사진을 삭제하기 위함)
                        }
                    });

                    list.remove(0); // 가장 오랜된 사진 삭제
                    list.add(new People(idx, number, 1)); // 새로운 사진 추가
                    idx++;
                } else {
                    list.add(new People(idx, number, 1));
                    idx++;
                }
            }

            flag = true;
        }

        // 오름차순 정렬
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i).number+" ");
        }

        bw.flush();

        bw.close();
        br.close();
    }

}

