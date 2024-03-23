package com.example.programmers;

public class s258705 {

  static int[][] dp;
  static int INF = 10007;

  public static int solution(int n, int[] tops) {
    dp = new int[n][4];
    return dfs(0, 0, tops);
  }

  static int dfs(int now, int shape, int[] tops) { //shape 0:앞블록 남아있음 1:앞블록 소모
    if (now == tops.length) {
      return 1;
    }

    if (dp[now][shape] != 0) {
      return dp[now][shape];
    }
    int sum = 0;
    if (shape == 0 && tops[now] == 1) { //모두 남아있음
      sum += 3 * dfs(now + 1, 0, tops) + dfs(now + 1, 1, tops);
    } else if (shape == tops[now]) { //앞블럭만 남아있음 or 윗블럭만 남아있음
      sum += 2 * dfs(now + 1, 0, tops) + dfs(now + 1, 1, tops);
    } else { //둘다 없음
      sum += dfs(now + 1, 0, tops) + dfs(now + 1, 1, tops);
    }

    sum = sum % INF;
    dp[now][shape] = sum;
    return sum;
  }
}
