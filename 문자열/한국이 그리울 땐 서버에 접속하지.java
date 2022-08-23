import java.io.*;

/*   Baekjoon 9996번 - 한국이 그리울 땐 서버에 접속하지 (Silver Ⅲ)
*    문제 푼 날짜 : 2022 - 08 - 23
*    메모리 : 14176 KB
*    시간 : 128 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 파일의 개수

        String pattern = br.readLine(); // 패턴

        int star = pattern.indexOf('*'); // *이 위치한 인덱스

        String front = pattern.substring(0, star); // *을 기준으로 앞에 위치한 문자열
        String back = pattern.substring(star+1); // *을 기준으로 뒤에 위치한 문자열

        for(int i=0; i<N; i++){
            String fileName = br.readLine(); // 파일 이름 입력

            // 패턴에서 *을 기준으로 앞과 뒤 문자열을 합친 길이가 fileName의 길이보다 길면 패턴이 일치할 수 없다. 
            if(front.length() + back.length() > fileName.length()){
                bw.write("NE\n");
                continue;
            }
            
            // 파일 이름에서 front 문자열의 길이만큼 분할
            String s1 = fileName.substring(0, front.length());
            // 파일 이름에서 맨 뒤에서부터 back 문자열의 길이만큼 분할 
            String s2 = fileName.substring(fileName.length()-back.length(), fileName.length());

            // 만약 분할된 파일 이름들이 패턴과 일치하면
            if(s1.equals(front) && s2.equals(back))
                bw.write("DA\n");
            else
                bw.write("NE\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}


