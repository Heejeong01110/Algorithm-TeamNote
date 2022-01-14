import java.io.*;
import java.util.*;

public class q1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][3]; //[i번째줄에][j칸 또는 0개 넣는경우]
        
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2])%9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2])%9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }


        bw.write((dp[N][0] + dp[N][1] + dp[N][2])%9901 + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

}
