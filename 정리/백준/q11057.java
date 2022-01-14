import java.io.*;
import java.util.*;

public class q11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());
        int result = 0;
        long[][] dp = new long[N + 1][10]; //길이가 N일때, 뒷자리 숫자가 i인 경우

        for(int i=0;i<10;i++){
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k]%10007;
                }
            }
        }

        for(int i=0;i<10;i++){
            result+=dp[N][i] % 10007;
        }
        
        bw.write(result % 10007 + "\n");

        

        bw.flush();
        br.close();
        bw.close();
    }

}
