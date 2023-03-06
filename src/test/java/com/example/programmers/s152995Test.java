package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s152995Test {

  @Test
  void solution() {
    s152995 question = new s152995();
    assertEquals(5,
        question.solution(new int[][]{{3, 1}, {1, 4}, {2, 3}, {2, 3}, {1, 5}, {1, 0}, {1, 0}}));
    assertEquals(4, question.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
    assertEquals(1, question.solution(new int[][]{{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}}));
  }
}
