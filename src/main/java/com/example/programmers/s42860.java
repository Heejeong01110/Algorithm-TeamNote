package com.example.programmers;

public class s42860 {

  public static int solution(String name) {
    int answer = 0;
    int length = name.length();

    int move = length - 1;
    int index;

    for (int i = 0; i < name.length(); i++) {
      answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

      index = i + 1;
      while (index < length && name.charAt(index) == 'A') {
        index++;
      }

      move = Math.min(move, i * 2 + length - index);
      move = Math.min(move, (length - index) * 2 + i);

    }

    return answer + move;
  }

}
