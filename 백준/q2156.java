import java.io.*;
import java.util.*;

public class q2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        Integer[] map = new Integer[N];
        int result = 0;
        Integer[][] dp = new Integer[N + 1][3];

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = 0;
        dp[0][1] = map[0];
        dp[0][2] = 0;

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = dp[i - 1][0] + map[i];
            dp[i][2] = dp[i - 1][1] + map[i];
        }
        
        for (int i = 0; i < N; i++) {
            bw.write(dp[i][0]+" "+dp[i][1]+" "+ dp[i][2]+" "+ "\n");
        }

        bw.write(Math.max(dp[N-1][0], Math.max(dp[N - 1][1], dp[N - 1][2])) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

}
