package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s133500Test {

  @Test
  void solution() {
    s133500 question = new s133500();
    assertEquals(3, question.solution(10,new int[][]{{4, 1},{5, 1},{5, 6},{7, 6},{1, 2},{1, 3},{6, 8},{2, 9},{9, 10}}));
    assertEquals(2, question.solution(8,new int[][]{{1, 2},{1, 3},{1, 4},{1, 5},{5, 6},{5, 7},{5, 8}}));
  }
}
