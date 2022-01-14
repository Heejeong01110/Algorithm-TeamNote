import java.io.*;

public class q10870 {
    static int[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        if (N == 0) {
            bw.write("0\n");
            bw.flush();
            br.close();
            bw.close();
            return;
        }
        memory = new int[N+1];


        bw.write(fibo(N) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static int fibo(int n) {
        if (n == 0) {
            memory[0] = 0;
            return memory[n];
        } else if (n == 1) {
            memory[1] = 1;
            return memory[n];
        }

        memory[n] = fibo(n-1) + fibo(n - 2);

        return memory[n];
    }

}
