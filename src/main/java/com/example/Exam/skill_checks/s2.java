package com.example.Exam.skill_checks;

import java.util.ArrayList;

//사칙연산
public class s2 {

  public static int solution(int N, int number) {
    ArrayList<Integer>[] dp = new ArrayList[9];
    for (int i = 0; i < 9; i++) {
      dp[i] = new ArrayList<>();
    }

    dp[1].add(N);

    if (number == N) {
      return 1;
    }

    Integer[] middleCalc = new Integer[6];
    for (int i = 2; i < 9; i++) {

      dp[i].add(dp[i - 1].get(0) * 10 + N);
      if (dp[i].get(0) == number) {
        return i;
      }
      for (int j = 1; j <= i / 2; j++) {
        int aIndex = j;
        int bIndex = i - j;

        for (int a = 0; a < dp[aIndex].size(); a++) {
          for (int b = 0; b < dp[bIndex].size(); b++) {
            middleCalc[0] = dp[aIndex].get(a) + dp[bIndex].get(b);
            middleCalc[1] = dp[aIndex].get(a) - dp[bIndex].get(b);
            middleCalc[2] = dp[aIndex].get(a) * dp[bIndex].get(b);
            middleCalc[3] = dp[aIndex].get(a) / dp[bIndex].get(b);
            middleCalc[4] = dp[bIndex].get(b) - dp[aIndex].get(a);
            middleCalc[5] = dp[bIndex].get(b) / dp[aIndex].get(a);

            for (int k = 0; k < 6; k++) {
              if (middleCalc[k] == number) {
                return i;
              }
              if (middleCalc[k] >= 1 && middleCalc[k] <= 32000 && !dp[i].contains(middleCalc[k])) {
                dp[i].add(middleCalc[k]);
              }
            }
          }
        }
      }

    }

    return -1;
  }

}
