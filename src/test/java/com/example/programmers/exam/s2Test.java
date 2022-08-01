package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.programmers.exam.s2;
import org.junit.jupiter.api.Test;

class s2Test {

  @Test
  void solution() {
    assertEquals(3, s2.solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
        new int[]{3, 2, 2, 2, 1},
        new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
            "pork", "rice", "pot", "banana", "apple", "banana"}));
    assertEquals(0, s2.solution(new String[]{"apple"}, new int[]{10},
        new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
            "banana", "banana"}));

  }
}
