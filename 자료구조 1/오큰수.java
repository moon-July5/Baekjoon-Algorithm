import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


/*   Baekjoon 17298번 - 오큰수 (Gold Ⅳ)
*    문제 푼 날짜 : 2022 - 06 - 18
*    메모리 : 145760 KB
*    시간 : 1060 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    // 수열 크기
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열을 배열에 저장
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        // 배열에 담긴 정수를 하나씩 비교하며 확인
        for(int i=0; i<N; i++){

            // 오른쪽에 있는 큰 수(현재 위치보다 뒤에 있는 인덱스) 중에서 가장 왼쪽에 있는 수로 변경하기 위한 while문
            // 일단, 스택이 비어있지 않아야 하며,
            // 현재 배열 값 > 스택에 가장 맨 위에 있는 값(인덱스)의 배열 값보다 크면 "오큰수"다.
            while(!stack.isEmpty() && arr[i]>arr[stack.peek()]){
                // 스택에 가장 맨 위에 담긴 인덱스에 있는 값을 현재 배열 값으로 변경
                arr[stack.pop()] = arr[i];
            }

            // 스태이 비어있다면 인덱스를 저장
            stack.push(i);
        }

        // 스택이 비어있지 않다면, 즉, 자기 오른쪽에 큰 수가 없거나 마지막 원소일 경우
        while(!stack.isEmpty()){
            // -1로 저장
            arr[stack.pop()] = -1;
        }

        for(int n : arr)
            bw.write(n+" ");

        bw.close();
        br.close();
    }
}

/*
 처음에 당연히 이중 for문을 생각했지만 입력 데이터의 범위를 봤을 때 시간초과가 날 것 같았다.
  
 그래서 이 오큰수를 구하기 위해 계속 생각해 봤지만 도저히 생각이 나질 않아 다른 분 것을 참고했다.
 참고하면서 정말 어떻게 이런 생각을 할 수 있는지 놀랐고 아직은 많이 풀어봐야 하지만 
 덕분에 실력 향상에 한 걸음 더 다가간 것 같은 느낌이 들었다. 
 */