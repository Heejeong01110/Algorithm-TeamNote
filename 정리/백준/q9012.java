import java.io.*;
import java.util.Stack;

public class q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 0;
        int temp = 0;
        String cmd;
        Stack<Character> stack = new Stack<Character>();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            cmd = br.readLine();
            temp = 0;
            stack.removeAllElements();
            for (int j = 0; j < cmd.length(); j++) {
                switch (cmd.charAt(j)) {
                    case '(':
                        stack.push('(');
                        break;
                    case ')':
                        if (stack.size() == 0) {
                            temp = 1;
                        } else {
                            stack.pop();
                        }
                        break;
                    default:
                        break;
                }
            }

            if (temp == 1) {
                bw.write("NO\n");
            } else if (stack.size() != 0) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
