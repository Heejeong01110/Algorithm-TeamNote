import java.io.*;
import java.util.Stack;

public class q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stackF = new Stack<Character>();
        Stack<Character> stackB = new Stack<Character>();
        
        
        StringBuilder str = new StringBuilder();
        str.append(br.readLine());

        for(int i=0;i<str.length();i++){
            stackF.push(str.charAt(i));
        }

        String cmd0 = "";

        int M = Integer.parseInt(br.readLine()); //명령어의 갯수

        for (int j = 0; j < M; j++) {
            cmd0 = br.readLine(); //명령 입력
            switch (cmd0.charAt(0)) {
                case 'L':
                    if(!stackF.isEmpty()){
                        stackB.push(stackF.pop());
                    }
                    break;
                case 'D':
                    if(!stackB.isEmpty()){
                        stackF.push(stackB.pop());
                    }
                    break;
                case 'B':
                    if(!stackF.isEmpty()){ //맨 앞글자 삭제
                        stackF.pop();
                    }
                    break;
                case 'P':
                    stackF.push(cmd0.charAt(2));
                    break;
            }
            
        }
        
        while(!stackF.isEmpty()){
            stackB.push(stackF.pop());
        }
        while(!stackB.isEmpty()){
            bw.write(stackB.pop());
        }
        bw.write("\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
