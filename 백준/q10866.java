import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String str;
        String[] cmd = new String[2];
        Deque<Integer> deque = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            cmd = str.split("\\s");
            switch (cmd[0]) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(cmd[1]));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(cmd[1]));
                    break;
                case "pop_front":
                    if (deque.size() == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollFirst() + "\n");
                    }
                    break;
                case "pop_back":
                    if (deque.size() == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollLast() + "\n");
                    }
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if (deque.size() == 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (deque.size() == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if (deque.size() == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekLast() + "\n");
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