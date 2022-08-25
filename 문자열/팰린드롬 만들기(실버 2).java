import java.io.*;


/*   Baekjoon 1254번 - 팰린드롬 만들기 (Silver Ⅱ)
*    문제 푼 날짜 : 2022 - 08 - 25
*    메모리 : 14316 KB
*    시간 : 132 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine(); // 문자열 입력

        int answer = s.length();

        for(int i=0; i<s.length(); i++){
            // 팰린드롬이 맞다면 break
            if(check(s.substring(i))) break;
            // 팰린드롬이 아니면 answer의 값을 추가 ( 문자 하나를 더 추가 )
            answer++;
        }

        bw.write(answer+"");

        bw.close();
        br.close();
    }

    // 전달받은 문자열이 팰린드롬인지 판별하는 메서드
    public static boolean check(String s){
        int start = 0; // 전달받은 문자열의 첫 문자
        int end = s.length() - 1; // 전달받은 문자열의 마지막 문자

        while (start <= end){
            // 두 문자를 비교했을 때 서로 같지 않다면 팰린드롬이 성립하지 않음
            if(s.charAt(start) != s.charAt(end)) return false;

            // 다음 문자를 비교하기 위해
            start++;
            end--;
        }

        return true;
    }
}


