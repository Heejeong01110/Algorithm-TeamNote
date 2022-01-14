import java.io.*;
import java.util.*;

public class q1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int addNum = 0;
        while (S >= sum) {
            sum += (++addNum);
        }

        if (sum == S) {
            bw.write(addNum + "\n");
        } else {
            bw.write((addNum - 1) + "\n");
        }
        


        br.close();
        bw.flush();
        bw.close();
    }
}
