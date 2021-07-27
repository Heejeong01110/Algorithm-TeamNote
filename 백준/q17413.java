import java.io.*;
import java.util.Stack;

public class q17413 {
 public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = br.readLine();
    Stack<Character> stack = new Stack<Character>();
    int index=0;
    int pass=0;
    for(int i=0;i<str.length();i++){ //태그 출력
        if(pass > 0){
            if(str.charAt(index) == '>'){//닫힘태그 등장
                pass -=1;
            }
            bw.write(str.charAt(index++));
        }else if(str.charAt(index) == '<'){ //태그 시작
            pass += 1;
            bw.write(str.charAt(index++));
        }else if(str.charAt(index) == ' '){ //공백일 때
            while(!stack.isEmpty()){
                bw.write(stack.pop());
            }
            bw.write(" ");
            index++;
        }else if(index == str.length()-1||str.charAt(index+1)=='<'){ //마지막 단어()
            stack.push(str.charAt(index));
            while(!stack.isEmpty()){
                bw.write(stack.pop());
            }
            index++;
        }else{//단어일 때,
            stack.push(str.charAt(index++));
        }

    }

    br.close();
    bw.flush();
    bw.close();
    
    
 }  
}
