package com.example.Exam.skill_checks;

//추석트래픽
public class s1 {

  public static int solution(String[] lines) {
    int[][] logs = new int[lines.length][2];

    for (int i = 0; i < lines.length; i++) {
      String[] strs = lines[i].split(" ");

      int end = getTime(strs[1]);
      int range = getTime(strs[2]);

      logs[i][0] = end - range + 1;
      logs[i][1] = end;
      System.out.println(logs[i][0]+" "+logs[i][1]);
    }

    int currentCount = 0;
    int maxCount = 0;

    for (int i = 0; i < logs.length; i++) {
      currentCount = 0;
      for (int j = i; j < logs.length; j++) {
        if (logs[i][1] + 1000 > logs[j][0]) { //1초 범위 내에서 시작하는 로그가 몇개인지 체크
          currentCount++;
        }


      }

      maxCount = Math.max(maxCount, currentCount);

    }

    return maxCount;
  }

  private static int getTime(String str) {
    String s = str.replace(".", ":").replace("s", "");

    String[] times = s.split("\\:");

    if (times.length == 2) {
      return Integer.parseInt(times[0]) * 1_000 + Integer.parseInt(times[1]);
    } else if (times.length == 1) {
      return Integer.parseInt(times[0]) * 1_000;
    }
    return Integer.parseInt(times[0]) * 3600_000 + Integer.parseInt(times[1]) * 60_000
        + Integer.parseInt(times[2]) * 1_000 + Integer.parseInt(times[3]);
  }

}
