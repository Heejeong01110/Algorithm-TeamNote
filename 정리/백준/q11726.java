import java.io.*;

public class q11726 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        dpFunc(N);

        /*
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }*/

        bw.write(dp[N] + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
    
    static Integer dpFunc(int n) {
        if (n == 1) {
            return dp[n];
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        
        dp[n] = (dpFunc(n-1) + dpFunc(n-2))%10007;
        return dp[n];

    }
    
    
}
