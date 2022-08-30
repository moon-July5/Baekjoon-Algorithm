import java.io.*;

/*   Baekjoon 9081번 - 단어 맞추기 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 08 - 30
*    메모리 : 14140 KB
*    시간 : 128 ms
 */
public class Main {
    private static char[] word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int t = 0; t < T; t++) {
            word = br.readLine().toCharArray();

            if (nextPermutation()) {
                for (char ch : word)
                    bw.write(ch);
                bw.write("\n");
            } else {
                for (char ch : word)
                    bw.write(ch);
                bw.write("\n");
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }
    // 단어 맨 뒤에서부터 확인하면서 감소하는 부분 찾기
    public static boolean nextPermutation() {
        // 교환 위치 찾기
        int idx = word.length - 1;

        while (idx > 0 && word[idx - 1] >= word[idx]) --idx;
        if (idx == 0) return false;   // idx가 0이면 다음 순열이 없으므로 false 반환

        // 교환할 위치 찾기
        int idx2 = word.length - 1;
        while (word[idx - 1] >= word[idx2]) --idx2;

        // 교환
        char temp = word[idx - 1];
        word[idx - 1] = word[idx2];
        word[idx2] = temp;

        // 교환 위치 이후 값 정렬
        int idx3 = word.length - 1;
        while (idx < idx3) {
            temp = word[idx];
            word[idx] = word[idx3];
            word[idx3] = temp;
            ++idx;
            --idx3;
        }

        return true;
    }
}



