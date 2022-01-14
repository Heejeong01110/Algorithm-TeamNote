import java.io.*;
import java.util.*;

public class q17299 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //현재 인덱스 이전에 등장한 적이 있는 수 && 전체 갯수가 더 많은 수

        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int num[] = new int[N];
        int numCnt[]= new int[N]; //메모리 문제발생 가능할수있음
        //hashmap 을 쓰면 해결됨
        int result[] = new int[N];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(str[i]);
            numCnt[num[i]] +=1;
        }

        stack.push(0);
        for(int i=0;i<N;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }
                    while(!stack.isEmpty() && numCnt[num[stack.peek()]]<numCnt[num[i]]){
                        result[stack.pop()] = num[i];
                    }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        for(int i=0;i<N;i++){
            bw.write(result[i]+" ");
        }



        br.close();
        bw.flush();
        bw.close();
    }
}
