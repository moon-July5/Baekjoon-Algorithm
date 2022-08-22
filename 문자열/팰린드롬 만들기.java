import java.io.*;

/*   Baekjoon 1213번 - 팰린드롬 만들기 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 22
*    메모리 : 16436 KB
*    시간 : 168 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        // 주어진 문자열의 알파벳 개수를 저장할 공간
        int[] alpha = new int[26];

        // 문자열의 알파벳 개수 계산
        for(int i=0; i<s.length(); i++){
            alpha[s.charAt(i) - 'A']++;
        }

        int count = 0;

        // 알파벳의 개수가 홀수개인 경우 count
        for(int i=0; i<alpha.length; i++){
            if(alpha[i]%2 == 1) count++;
        }

        String answer = "";
        StringBuilder sb = new StringBuilder();

        // 알파벳의 개수가 홀수개인 경우가 2 이상이면 팰린드롬을 만들 수 없다.
        if(count>1) answer += "I'm Sorry Hansoo";
        else {
            // 앞의 문자열을 팰린드롬을 만들기 위함
            for(int i=0; i<alpha.length; i++){
                for(int j=0; j<alpha[i]/2; j++){
                    sb.append((char) (i+65));
                }
            }
            answer += sb.toString();
            String end = sb.reverse().toString(); // 끝 부분의 문자열을 저장

            sb = new StringBuilder();

            // 홀수개를 가지는 문자열을 저장
            for(int i=0; i<alpha.length; i++){
                if(alpha[i]%2 == 1){
                    sb.append((char) (i+65));
                }
            }

            // 앞 문자열 + 중간 문자열 + 끝 문자열
            answer += sb.toString() + end;
        }

        bw.write(answer);
        bw.flush();

        bw.close();
        br.close();
    }
}


