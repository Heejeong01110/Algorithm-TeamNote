package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s172927Test {

  @Test
  void solution() {
    s172927 question = new s172927();
    assertEquals(50, question.solution(
        new int[]{0, 1, 1},
        new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron",
            "iron", "iron", "diamond"}));
    assertEquals(12, question.solution(
        new int[]{1, 3, 2},
        new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));

  }
}
