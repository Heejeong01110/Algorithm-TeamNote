import java.io.*;
import java.util.*;

public class q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        int[] number = new int[n];
        int numTemp = 1; // 1,2,3 오름차숫 숫자
        int numT2 = 0; // 몇번쨰까지 이전에 넣었는지 저장
        StringBuilder sb = new StringBuilder();

        // 넣었다가 뽑아 늘어놓았을 때 4,3,6,8,7,5,2,1
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }
        // 만약 마지막이 1,2,5 이런 숫자로 끝나면 NO임

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || number[i] > stack.peek()) { // push 해야하는 경우 4/123
                for (int j = numT2; j < number[i]; j++) {// 1,2,3,4 들어감
                    stack.push(numTemp++);
                    sb.append("+\n");
                }
                numT2 = numTemp - 1;
                stack.pop();
                sb.append("-\n");
            } else if (number[i] == stack.peek()) { // 같을경우.pop해야함 3/3
                stack.pop();
                sb.append("-\n");
            } else {// 4/5,6,7,8
                sb.delete(0, sb.length());
                sb.append("NO\n");
                i = n;
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
//String자료형을 아예 쓰지 않고 버퍼에 한글자씩 넣어서 버퍼를 바로 출력시키는 방법
