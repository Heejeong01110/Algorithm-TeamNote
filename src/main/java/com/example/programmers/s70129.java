package com.example.programmers;

public class s70129 {

  public static int[] solution(String s) {
    int[] answer = new int[]{0, 0};

    while (!s.equals("1")) {
      String newS = s.replaceAll("0", "");
      answer[1] += s.length() - newS.length();
      s = Integer.toBinaryString(newS.length());
      answer[0] += 1;
    }

    return answer;
  }
}
