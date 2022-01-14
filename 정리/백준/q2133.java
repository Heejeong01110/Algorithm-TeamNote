import java.io.*;
import java.util.*;

public class q2133 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 0;
        if (N >= 2) {
            dp[2] = 3;
        }
        
        for (int i = 3; i <= N; i++) {
            if(i%2 ==0){
                dp[i] = (dp[i - 2] * 3);
                for (int j = 0; j < i - 2; j += 2) {
                    dp[i] += (dp[j] * 2);
                }
            }
            bw.write(i + " : " + dp[i] + "\n");
        }

        
        bw.write(dp[N]+ "\n");

        bw.flush();
        br.close();
        bw.close();
    }

}
