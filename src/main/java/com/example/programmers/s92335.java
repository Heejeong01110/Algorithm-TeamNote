package com.example.programmers;

public class s92335 {

  public int solution(int n, int k) {
    int answer = 0;

    String str = Integer.toString(n, k);

    int idx = 0;
    String now = "";

    String[] ary = str.split("0");
    for (int i = 0; i < ary.length; i++) {
      if (ary[i].isBlank()) {
        continue;
      }
      long num = Long.parseLong(ary[i]);
      if(isCorrect(num)){
        answer++;
      }
    }

    return answer;
  }

  private boolean isCorrect(long number) {
    if (number <= 1) {
      return false;
    }

    double sqrt = Math.sqrt(number);
    for (double i = 2; i <= sqrt; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
