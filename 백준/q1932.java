import java.io.*;
import java.util.*;

public class q1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = map[n - 1][i];
        }

        for (int i = n-2; i >=0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i +1][j], dp[i+1][j+1]) + map[i][j];
            }
        }

        /*
        dp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) { //맨 왼쪽줄
                    dp[i][j] = dp[i - 1][j] + map[i][j];
                } else if (j == i) { //맨 오른쪽 줄
                    dp[i][j] = dp[i - 1][j - 1] + map[i][j];
                } else { //가운데 줄
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            //result = Math.max(result, dp[n - 1][i]);
            result = Math.max(result, calculation(n - 1, i, dp, map));
        }
        */
        result = dp[0][0];

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
    
    
    static Integer calculation(int i, int j, int[][] dp, int[][] map) {
        if (i == 0 && j == 0) {
            return map[i][j];
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (j == 0) { // 맨 왼쪽줄
            dp[i][j] = calculation(i-1,j,dp,map) + map[i][j];
        } else if (j == i) { // 맨 오른쪽 줄
            dp[i][j] = calculation(i - 1, j-1, dp, map) + map[i][j];
        } else { // 가운데 줄
            dp[i][j] = Math.max(calculation(i - 1, j - 1, dp, map), calculation(i - 1, j, dp, map)) + map[i][j];
        }


        return dp[i][j];
    }
}
