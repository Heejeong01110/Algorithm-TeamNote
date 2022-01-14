import java.io.*;

public class q1003 {
    static int[][] fibo = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        fibo[0][0] = 1;
        fibo[1][0] = 0;
        fibo[0][1] = 0;
        fibo[1][1] = 1;

        Integer T = Integer.parseInt(br.readLine()); // testcase
        Integer n = 0;

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            fiboZ(n);
            bw.write(fibo[n][0] + " " + fibo[n][1] + "\n");

        }

        bw.flush();
        br.close();
        bw.close();
    }
    
    static int[] fiboZ(int n) {
        if (n == 0 || n == 1) {

            return fibo[n];
        }

        if (fibo[n][0] != 0 || fibo[n][1] != 0) {
            return fibo[n];
        }
        fibo[n][0] = fiboZ(n - 1)[0] + fiboZ(n - 2)[0];
        fibo[n][1] = fiboZ(n - 1)[1] + fiboZ(n - 2)[1];

        return fibo[n];
    }
    
}
