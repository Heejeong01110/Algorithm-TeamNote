import java.io.*;
import java.util.Stack;

public class q10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String laser = br.readLine();
        Stack<Integer> stack = new Stack<Integer>();
        int total=0;

        for(int i=0;i<laser.length();i++){
            //01
            //33(모양()일경우 바로 pop 씀) 1(모양")"만 나왔을때) 3 1 2  1 1 
            if(laser.charAt(i)=='('){
                if(laser.charAt(i+1)==')'){ //레이저 나옴
                    if(!stack.isEmpty()){
                        total += stack.peek();
                    }
                    i++;
                }else{ //막대기 추가
                    if(!stack.isEmpty()){
                        stack.push(stack.peek()+1);
                    }else{
                        stack.push(1);
                    }
                }
            }else if(laser.charAt(i)==')'){
                stack.pop();
                total+=1;
            }
        }
        bw.write(total+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
