import java.io.*;

public class q2579 {
    static Integer[] memory;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        memory = new Integer[N+1];
        cost = new int[N+1];

        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        
        memory[0] = cost[0];
        memory[1] = cost[1];

        if (N >= 2) {
            memory[2] = cost[1] + cost[2];
        }

        bw.write(calc(N) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static int calc(int n) {
        if (memory[n] == null) {
            memory[n] = Math.max(calc(n - 2), calc(n - 3) + cost[n - 1]) + cost[n];
        }

        return memory[n];
    }

}
