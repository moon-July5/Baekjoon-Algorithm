import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*   Baekjoon 19637번 - IF문 좀 대신 써줘 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 10 - 20
*    메모리 : 55776 KB
*    시간 : 588 ms
 */
class Title{
    String name;
    int value;

    public Title(String name, int value){
        this.name = name;
        this.value = value;
    }
}
public class Main {
    public static ArrayList<Title> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 칭호의 개수와 칭호를 출력해야 하는 캐릭터들의 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        // 칭호의 이름과 해당 칭호의 전투력 상한값을 나타내는 정수 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            list.add(new Title(name, value));
        }

        // 캐릭터의 전투력 입력
        for(int i=0; i<M; i++) {
            // 캐릭터 전투력
            int value = Integer.parseInt(br.readLine());

            // 이분탐색을 통해 칭호 탐색
            String answer = BinarySearch(value);

            // 칭호 출력
            bw.write(answer+"\n");

        }
        bw.flush();

        bw.close();
        br.close();
    }

    // 이분탐색
    public static String BinarySearch(int value) {
        int start = 0;
        int end = list.size()-1;

        while (start <= end){
            int mid = (start + end) / 2;

            if(value > list.get(mid).value) start = mid + 1;
            else end = mid - 1;
        }

        // 칭호 반환
        return list.get(end+1).name;
    }
}



