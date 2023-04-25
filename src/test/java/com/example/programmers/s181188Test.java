package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s181188Test {

  @Test
  void solution() {
    s181188 question = new s181188();
    assertEquals(3, question.solution(
        new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
  }
}
