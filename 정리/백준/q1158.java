import java.io.*;
import java.util.*;

public class q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        String str = br.readLine();
        String[] N = str.split("\\s");

        for (int i = 1; i <= Integer.parseInt(N[0]); i++) {
            queue.add(i);
        }

        bw.write("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < Integer.parseInt(N[1]) - 1; i++) {
                queue.add(queue.poll());
            }
            if (queue.size() == 1) {
                bw.write(queue.poll() + ">");
            } else {
                bw.write(queue.poll() + ", ");
            }

        }

        br.close();
        bw.flush();
        bw.close();
    }
}
