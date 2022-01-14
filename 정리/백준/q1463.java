import java.io.*;
import java.util.*;

public class q1463 {
    private static Integer minCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer result = 0;
        Integer X = Integer.parseInt(br.readLine());

        minCount = X;
        calculator(X, result);
        bw.write(minCount + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void calculator(Integer X, Integer count) {
        if (X == 1) {
            if (minCount > count) {
                minCount = count;
            }
            return;
        }
        if (count > minCount) {
            return;
        }
        Integer result = X;
        if (X % 3 == 0) {
            result = X / 3;
            calculator(result, count + 1);
        }
        if (X % 2 == 0) {
            result = X / 2;
            calculator(result, count + 1);
        }
        result = X - 1;
        calculator(result, count + 1);
    }
}
