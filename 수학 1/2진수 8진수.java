import java.io.*;

/*   Baekjoon 1373번 - 2진수 8진수 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 06 - 19
*    메모리 : 34788 KB
*    시간 : 380 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();   // 2진수

        // 2진수를 8진수로 변환시키기 위해서는 3자리마다 묶어줘야 하는데,
        // 맨 앞에있는 수들이 3자리가 안될 수 있기 때문에 1자리 일 경우, 2자리 일 경우를 처리한다.
        if(s.length()%3 == 1) bw.write((s.charAt(0)-'0')+"");
        else if(s.length()%3 == 2) bw.write((s.charAt(0)-'0')*2+(s.charAt(1)-'0')+"");

        // 여기서 3자리의 각 자릿수마다 4, 2, 1를 곱해줘서 8진수로 나타낸다.
        for(int i=s.length()%3; i<s.length(); i+=3){
            bw.write((s.charAt(i)-'0')*4+(s.charAt(i+1)-'0')*2+(s.charAt(i+2)-'0')+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}

