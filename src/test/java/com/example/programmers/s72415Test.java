package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s72415Test {

  @Test
  void solution() {
    s72415 question = new s72415();
    assertEquals(16, question.solution(new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}},0,1));
    assertEquals(14, question.solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}},1,0));
  }
}
