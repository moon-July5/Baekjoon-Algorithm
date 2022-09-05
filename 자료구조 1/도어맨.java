import java.io.*;
import java.util.*;

/*   Baekjoon 5002번 - 도어맨 (Silver Ⅰ)
*    문제 푼 날짜 : 2022 - 09 - 05
*    메모리 : 14232 KB
*    시간 : 124 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine()); // 정인이가 기억할 수 있는 가장 큰 차이

        String line = br.readLine();

        Queue<Character> queue = new LinkedList<>(); // 대기열을 나타냄

        int man = 0; // 남성의 수
        int woman = 0; // 여성의 수

        for(int i=0; i<line.length(); i++){
            char person = line.charAt(i); // 줄을 서 있는 사람

            if(!queue.isEmpty()){ // 현재 대기 중인 사람이 있다면
                if(queue.peek() == 'M'){ // 대기 중인 사람이 남성이고
                    if(Math.abs((man+1) - woman) <= X){ // 여성과의 차이가 X 이하라면
                        man++; // count
                        queue.poll(); // 대기열에서 삭제
                    }
                } else { // 여성이고
                    if(Math.abs(man - (woman+1)) <= X){
                        woman++;
                        queue.poll();
                    }
                }
            }

            if(person=='M'){ // 남성이라면
                if(Math.abs((man+1) - woman) <= X){ // 남성과 여성의 수 차이가 X 이하면
                    man++; // 남성의 수 count
                } else if(queue.isEmpty()){ // 대기열이 비어있다면
                    queue.add(person);
                } else {
                    break;
                }
            } else { // 여성이라면
                if(Math.abs(man - (woman + 1)) <= X){
                    woman++;
                } else if(queue.isEmpty()){
                    queue.add(person);
                } else {
                    break;
                }
            }
        }

        bw.write(man+woman+"");

        bw.close();
        br.close();
    }
}



