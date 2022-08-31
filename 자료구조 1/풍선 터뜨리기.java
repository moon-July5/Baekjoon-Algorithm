import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*   Baekjoon 2346번 - 풍선 터뜨리기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 31
*    메모리 : 16020 KB
*    시간 : 208 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        // 풍선 안의 종이 내용 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 처음은 1번 풍선을 터뜨린다.
        bw.write("1 ");

        // 2번 풍선 안의 내용과 인덱스를 함께 저장하기 위한 공간
        Deque<int[]> deque = new ArrayDeque<>();

        for(int i=1; i<N; i++)
            deque.add(new int[] {i+1, arr[i]}); // (풍선 번호, 풍선 내용)

        // 1번 풍선 안의 내용
        int b = arr[0];

        while(!deque.isEmpty()){
            // 양수일 경우
            if(b>0){
                for(int i=1; i<b; i++) deque.add(deque.poll()); // 풍선 안의 내용만큼 앞에서부터 번호 삭제 후 다시 뒤에 삽입

                int[] next = deque.poll(); // 앞에 있는 풍선 값을 불러온다.
                b = next[1]; // 풍선 내용 갱신
                bw.write(next[0]+" "); // 풍선 번호 출력
            } else { // 음수일 경우
                for(int i=1; i<-b; i++) deque.addFirst(deque.pollLast()); // 풍선 안의 내용만큼 가장 뒤에서부터 번호 삭제 후 앞에서 부터 삽입

                int[] next = deque.pollLast(); // 가장 뒤에 있는 풍선 값을 불러온다.
                b = next[1]; // 풍선 내용 갱신
                bw.write(next[0]+" "); // 풍선 번호 출력
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }
}



