import java.io.*;

public class q10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 0;
        String str;
        String[] cmd = new String[2];
        N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int stackN = -1;

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            cmd = str.split("\\s");
            switch (cmd[0]) {
                case "push":
                    stack[++stackN] = Integer.parseInt(cmd[1]);
                    break;
                case "pop":
                    if (stackN < 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack[stackN--] + "\n");
                    }
                    break;
                case "size":
                    bw.write((stackN + 1) + "\n");
                    break;
                case "empty":
                    if (stackN < 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "top":
                    if (stackN < 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack[stackN] + "\n");
                    }
                    break;
                default:
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}