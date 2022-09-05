import java.io.*;
import java.util.*;

/*   Baekjoon 11000번 - 강의실 배정 (Gold Ⅴ)
*    문제 푼 날짜 : 2022 - 09 - 05
*    메모리 : 68048 KB
*    시간 : 716 ms
 */
class Lecture{ // 강의 정보
    int start, end; // 시작 시간, 종료 시간

    public Lecture(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수업의 수

        Lecture[] lectures = new Lecture[N];

        // 강의 정보 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작 시간
            int end = Integer.parseInt(st.nextToken()); // 종료 시간

            lectures[i] = new Lecture(start, end);
        }

        // 강의 시작 시간 기준으로 오름차순으로 정렬.
        // 시작 시간이 같을 때, 종료 시간 기준으로 오름차순으로 정렬
        Arrays.sort(lectures, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if(o1.start == o2.start)
                    return o1.end - o2.end;

                return o1.start - o2.start;
            }
        });

        // 우선순위 큐에는 종료 시간만 저장
        // 우선순위 큐의 개수는 최소 강의실 개수를 나타낸다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);

        for(int i=1; i<N; i++){
            // 우선순위 큐의 종료 시간과 lectures[i]의 시작 시간을 비교
            // 우선순위 큐의 종료 시간보다 lectures[i]의 시작 시간이 크거나 같다는 의미는 
            // 1개의 강의실에서 강의를 해도 된다는 것으로 해석할 수 있다.
            if(pq.peek() <= lectures[i].start){
                pq.poll();
            }
            
            pq.add(lectures[i].end);
        }

        bw.write(pq.size()+"");

        bw.close();
        br.close();
    }
}



