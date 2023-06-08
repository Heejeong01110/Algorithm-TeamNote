package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s155651Test {

  @Test
  void solution() {
    s155651 question = new s155651();
    assertEquals(1, question.solution(
        new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
    assertEquals(3, question.solution(
        new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
    assertEquals(3, question.solution(
        new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"},
            {"14:10", "19:20"}, {"18:20", "21:20"}}));

  }

}
