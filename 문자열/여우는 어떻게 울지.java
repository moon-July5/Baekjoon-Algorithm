import java.io.*;

/*   Baekjoon 9536번 - 여우는 어떻게 울지? (Silver Ⅳ)
*    문제 푼 날짜 : 2022 - 08 - 20
*    메모리 : 14280 KB
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int t=0; t<T; t++){
            String[] record = br.readLine().split(" "); // 녹음된 소리

            String sound; // 여우를 제외한 동물들의 울음 소리

            // "what does the fox say?"가 나올 때까지 반복
            while(!(sound = br.readLine()).equals("what does the fox say?")){
                String[] s = sound.split(" "); 

                for(int i=0; i<record.length; i++){
                    // 동물들의 울음소리가 녹음된 소리와 같다면
                    if(s[2].equals(record[i]))
                        // 녹음된 동물의 소리를 빈칸으로 표시
                        record[i] = "";
                }
            }

            // 여우가 어떻게 우는지 출력
            for(String answer : record){
                // 출력할 때 빈칸은 제외한다
                if(!answer.equals(""))
                    bw.write(answer+" ");
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }
}


