import java.io.*;

/*   Baekjoon 2607번 - 비슷한 단어 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 23
*    메모리 : 14208 KB
*    시간 : 128 ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수

        String word = br.readLine(); // 비교할 첫 번째 단어

        int[] alpha = new int[26];

        // 첫 번째 단어의 알파벳의 개수를 count
        for(int i=0; i<word.length(); i++)
            alpha[word.charAt(i) - 'A']++;

        int answer = 0;

        for(int i=0; i<N-1; i++){
            String s = br.readLine();

            int count = 0;
            int[] temp = alpha.clone();

            for(int j=0; j<s.length(); j++){
                if(temp[s.charAt(j) - 'A'] > 0){ // 첫 번째 단어의 문자와 똑같은 문자가 존재하면
                    count++; // count
                    temp[s.charAt(j) - 'A']--;
                }
            }

            if(word.length()-1 == s.length() && count == s.length()){ // 길이가 한 글자 작을 때, 한 글자를 더 추가하면 된다.
                answer++; // 첫 번째 단어의 길이가 똑같고 문자가 완전히 일치하면 count
            } else if(word.length() == s.length()){ // 길이가 같을 때, 단어의 문자를 바꾸면 된다.
                if(count == word.length() || count == word.length()-1){
                    answer++;
                }
            } else if(word.length()+1 == s.length()) { // 길이가 한 글자 클 때, 한 글자를 삭제하면 된다.
                if(count == word.length()){
                    answer++;
                }
            }
        }
        bw.write(answer+"");

        bw.close();
        br.close();
    }

}


