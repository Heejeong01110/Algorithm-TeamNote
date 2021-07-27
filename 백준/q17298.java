import java.io.*;
import java.util.*;

public class q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split("\\s");
        int num[] = new int[N];
        int result[] = new int[N];

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(str[i]);
        }

        stack.push(0); //인덱스를 저장한다.
        for(int i=1;i<N;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }
            while(!stack.isEmpty()&&num[stack.peek()]<num[i]){
                //이미 값이 들어왔는데 그 수가 현재 인덱스값보다 작을때
                //인덱스자리에 이번 값을 넣음
                result[stack.pop()] = num[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        for(int i = 0; i < N; i++)
            bw.write(result[i]+" ");
            
        br.close();
        bw.flush();
        bw.close();
    }
}
