package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s1835Test {

  @Test
  void solution() {
    assertEquals(3648, s1835.solution(2, new String[]{"N~F=0", "R~T>2"}));
    assertEquals(0, s1835.solution(2, new String[]{"M~C<2", "C~M>1"}));
  }
}
