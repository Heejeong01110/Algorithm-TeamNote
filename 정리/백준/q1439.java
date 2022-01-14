import java.io.*;
import java.util.*;

public class q1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        boolean temp = false;
        int[] count = new int[2];

        if (S.charAt(0) == '1') {
            temp = true;
            count[1] += 1;
        }else if (S.charAt(0) == '0') {
            temp = false;
            count[0] += 1;
        }

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                if (!temp) {
                    temp = true;
                    count[1] += 1;
                }
            } else if (S.charAt(i) == '0') {
                if (temp) {
                    temp = false;
                    count[0] += 1;
                }
            }
        }

        
        bw.write(count[0]+" "+ count[1] + "\n");


        bw.write(Math.min(count[0],count[1]) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
