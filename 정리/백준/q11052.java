import java.io.*;
import java.util.*;

public class q11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Integer N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] packP = new Integer[N+1];
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            packP[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {//카드 i개 구매
            for (int j = 1; j <= i; j++) {
                dp[i] =Math.max(dp[i], dp[i - j]+packP[j]);
            }
        }
        

        bw.write(dp[N] + "\n");        
    

        bw.flush();
        br.close();
        bw.close();
    }

}
