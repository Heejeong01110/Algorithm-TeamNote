package com.example.programmers;

public class s12899 {

  static private String[] number = {"1", "2", "4"};

  public static String solution(int n) {
    StringBuilder answer = new StringBuilder();

    if(n==1){
      return number[0];
    }

    while (n > 0) {
      n -= 1;
      answer.insert(0, number[n % 3]);
      n /= 3;
    }

    return answer.toString();
  }

}
