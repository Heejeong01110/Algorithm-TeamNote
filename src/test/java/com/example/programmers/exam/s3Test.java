package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.programmers.exam.s3;
import org.junit.jupiter.api.Test;

class s3Test {

  @Test
  void solution() {
    assertEquals(5, s3.solution(new int[]{5, 4, 3, 2, 1}));
    assertEquals(2, s3.solution(new int[]{4, 3, 1, 2, 5}));
  }
}
