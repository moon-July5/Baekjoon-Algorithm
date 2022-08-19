import java.io.*;
import java.util.*;


/*   Baekjoon 1755번 - 숫자놀이 (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 08 - 19
*    메모리 : 16524 KB
*    시간 : 172 ms 
 */
class Number implements Comparable<Number>{
    String s; // 영어로 된 숫자
    int n; // 숫자

    Number(String s, int n){
        this.s = s;
        this.n = n;
    }

    @Override
    public int compareTo(Number o) {
        // 사전 순 정렬
        return this.s.compareTo(o.s);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 0부터 9까지 영어로 배열에 저장
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        PriorityQueue<Number> pq = new PriorityQueue<>();

        // M 이상 N 이하
        for(int i=M; i<=N; i++){
            String s = "";

            if(i<10) s = number[i];
            else {
                // 숫자 단위로 하나씩 읽는다.
                s += number[i/10] + " ";
                s += number[i%10];
            }
            // 우선순위 큐에 영어로 변환된 숫자와 값을 저장
            pq.add(new Number(s, i));
        }

        int count = 0; // 10개씩 끊어서 출력하기 위해 선언

        while (!pq.isEmpty()){
            Number num = pq.poll();

            count++;
            bw.write(num.n+" ");

            // 한 줄에 10개씩 끊어서 출력하기 위해 if문 작성
            if(count%10 == 0)
                bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}


