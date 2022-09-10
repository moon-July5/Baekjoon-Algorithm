import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*   Baekjoon 2503번 - 숫자 야구 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 09 - 10
*    메모리 : 25252 KB
*    시간 : 236 ms
 */
class BaseBall {
    int number, strike, ball;

    public BaseBall(int number, int strike, int ball){
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }
}
public class Main {
    private static int N;
    private static ArrayList<BaseBall> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 민혁이가 영수에게 한 질문 횟수

        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()); // 민혁이가 질문한 세자리 수
            int strike = Integer.parseInt(st.nextToken()); // 영수가 답한 스트라이크 개수
            int ball = Integer.parseInt(st.nextToken()); // 영수가 답한 볼 개수

            list.add(new BaseBall(number, strike, ball));
        }

        bw.write(solve()+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static int solve() {
        int answer = 0 ;

        for(int i=123; i<=987; i++){
            // 중복된 숫자가 있거나 0으로 이루어진 숫자가 있는 경우 다음 순서로
            if(!check(i)) continue;

            int count = 0; // 민혁이가 질문한 정보와 비교할 숫자와 일치한다면 count

            // 민혁이가 질문한 횟수 만큼
            for(int j=0; j<N; j++){
                int strike = 0; // 스트라이크의 개수
                int ball = 0; // 볼의 개수

                BaseBall baseBall = list.get(j); // 질문 정보 얻어옴
                String questionNumber = String.valueOf(baseBall.number); // 민혁이가 질문한 세자리 수
                String compareNumber = String.valueOf(i); // 비교할 숫자

                // 스트라이크의 개수
                for(int k=0; k<3; k++){
                    if(compareNumber.charAt(k) == questionNumber.charAt(k)){
                        strike++;
                    }
                }

                // 볼의 개수
                for(int k=0; k<3; k++){
                    for(int q=0; q<3; q++){
                        if(compareNumber.charAt(k) == questionNumber.charAt(q)){
                            // 만약 비교할 숫자와 민혁이가 질문한 세자리 수의 숫자와 같고 자리까지 똑같다면 스트라이크이기 때문에
                            // 볼이 되면 안된다. 그래서 k != q의 조건이 붙여야 한다.
                            if(k != q){
                                ball++;
                            }
                        }
                    }
                }

                // 민혁이가 질문한 정보와 비교한 숫자의 정보와 일치한다면 count
                if(baseBall.strike==strike && baseBall.ball==ball)
                    count++;
            }

            if(count==N)
                answer++;
        }

        return answer;
    }

    // 세 자리수에 중복 숫자가 포함되어 있거나 0으로 이루어진 숫자가 있는 경우 false 반환하는 메서드
    public static boolean check(int i) {
        String value = String.valueOf(i);

        if(value.charAt(0)==value.charAt(1) || value.charAt(1)==value.charAt(2) || value.charAt(0)==value.charAt(2))
            return false;

        if(value.charAt(0)=='0' || value.charAt(1)=='0' || value.charAt(2)=='0')
            return false;

        return true;
    }
}



