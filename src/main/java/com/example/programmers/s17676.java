package com.example.programmers;

import java.util.ArrayList;

public class s17676 {

  public static int solution(String[] lines) {
    int answer = 0;

    ArrayList<CustomLog> logList = new ArrayList<>();

    for (int i = 0; i < lines.length; i++) {
      String[] sp = lines[i].split(" ");
      int end = getTime(sp[1]); //end 까지는 포함. 다음 숫자부터 X
      int range = getRange(sp[2]);

      logList.add(new CustomLog(end - range + 1, end));
    }

    int[] dp = new int[logList.size()];

    for (int i = 0; i < logList.size(); i++) {
      long nowEnd = logList.get(i).end;
      long range = nowEnd + 1000;

      for (int j = i; j < logList.size(); j++) {
        long compareStart = logList.get(j).start;
        if (compareStart < range) {
          dp[i]++;
        }
      }

    }

    for (int i = 0; i < dp.length; i++) {
      if (answer < dp[i]) {
        answer = dp[i];
      }
    }

    return answer;
  }


  private static int getRange(String str) {
    String time = str.substring(0, str.length() - 1);
    String[] sp = time.split("\\.");

    if (sp.length == 1) { //2s
      return Integer.parseInt(sp[0]) * 1_000;
    }

    //2.0s
    return Integer.parseInt(sp[0]) * 1_000 + Integer.parseInt(sp[1]);

  }

  private static int getTime(String line) {
    String[] split = line.split(":");
    String[] second = split[2].split("\\.");

    return Integer.parseInt(split[0]) * 3_600_000
        + Integer.parseInt(split[1]) * 60_000
        + Integer.parseInt(second[0]) * 1_000
        + Integer.parseInt(second[1]);
  }

  private static class CustomLog {

    int start;
    int end;

    public CustomLog(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }


}
