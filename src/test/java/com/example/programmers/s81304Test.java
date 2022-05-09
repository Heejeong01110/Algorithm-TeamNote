package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s81304Test {

  @Test
  void solution() {
    assertEquals(4, s81304.solution(4,1,4,new int[][]{{1,2,1},{3,2,1},{2,4,1}},new int[]{2,3}));
    assertEquals(5, s81304.solution(3,1,3,new int[][]{{1,2,2},{3,2,3}},new int[]{2}));
  }
}
