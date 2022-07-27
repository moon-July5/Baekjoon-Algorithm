import java.io.*;
import java.util.*;

/*   Baekjoon 9047번 - 6174 (Bronze Ⅰ)
*    문제 푼 날짜 : 2022 - 07 - 27
*    메모리 : 16076 KB
*    시간 : 152 ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t=0; t<T; t++){
            int num = Integer.parseInt(br.readLine());

            int count = 0;

            // 숫자가 6174가 될 때 까지 연산 반복
            while(num != 6174){
                ArrayList<Integer> list = new ArrayList<>();

                // 각 자릿수를 list에 저장
                while(num > 0){
                    list.add(num % 10);
                    num /= 10;
                }

                // 각 자릿수를 list에 저장했는데, 4자리가 안되는 경우 4자리를 맞추기 위해 0을 추가
                // 예를 들어 설명하면, 1000을 입력받을 때, 큰 수가 1000, 작은 수가 1이 되는데,
                // 1000 - 1을 뺄 경우, 999가 되어 다음 연산이 안되기 때문에 0을 추가하여 4자리를 맞춘다.
                while(list.size()<4) list.add(0);

                Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬
                int max = list.get(0)*1000 + list.get(1)*100 + list.get(2)*10 + list.get(3); // 큰 수

                Collections.sort(list); // 오름차순 정렬
                int min = list.get(0)*1000 + list.get(1)*100 + list.get(2)*10 + list.get(3); // 작은 수

                num = max - min; 

                count++;
            }

            bw.write(count+"\n");
        }

        bw.close();
        br.close();
    }
}

