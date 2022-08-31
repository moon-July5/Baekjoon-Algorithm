import java.io.*;
import java.util.Stack;
import java.util.TreeSet;

/*   Baekjoon 6443번 - 애너그램 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 31
*    메모리 : 71252 KB
*    시간 : 1048 ms
 */
public class Main {
    private static int N; // 영단어의 개수
    private static char[] word; // 영단어를 char 타입의 배열로 저장
    private static int[] check; // 각 영단어의 알파벳 개수 저장
    private static Stack<Character> stack; // 영단어의 문자 저장
    private static TreeSet<String> treeSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for(int i=0; i<N; i++){
            word = br.readLine().toCharArray();

            treeSet = new TreeSet<>();
            check = new int[26];
            stack = new Stack<>();

            // 각 영단어의 알파벳 개수 확인
            for(char c : word) check[c - 'a']++;

            comb(word.length);

            treeSet.stream().forEach(s -> result.append(s).append("\n"));
        }
        bw.write(result.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void comb(int length){
        // 각 영단어의 길이만큼 저장이 완료됐으면
        if(length == stack.size()){
            StringBuilder sb = new StringBuilder();

            for(char c : stack) sb.append(c);

            // TreeSet에 저장하여 중복 제거 ( 정렬과, 검색에 유용)
            treeSet.add(sb.toString());
        }

        for(int i=0; i<26; i++){
            // 영단어의 문자가 있다면
            if(check[i] > 0){
                check[i]--; // 하나 제거
                stack.push((char) (i+'a')); // 스택에 저장
                comb(length); // 재귀 호출
                stack.pop(); // 재귀 호출 후 스택에 있는 문자들을 제거
                check[i]++; // 다시 알파벳의 갯수 원상복구
            }
        }
    }

}



