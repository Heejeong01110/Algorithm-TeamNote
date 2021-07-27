import java.io.*;

public class q9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] memory = new int[11]; //최대 11인 Memorization
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 4;

        Integer result = 0;
        Integer T = Integer.parseInt(br.readLine()); //testcase
        Integer n = 0;

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            if (memory[n] == 0) {
                for (int j = 4; j <= n; j++) {
                    memory[j] = memory[j - 1] + memory[j - 2] + memory[j - 3];
                }
            }
            bw.write(memory[n] + "\n");

        }

        bw.flush();
        br.close();
        bw.close();
    }
}
