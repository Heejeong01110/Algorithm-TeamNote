package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s17685Test {

  @Test
  void solution() {
    assertEquals(7, s17685.solution(new String[]{"go", "gone", "guild"}));
    assertEquals(4, s17685.solution(new String[]{"abc", "def", "ghi", "jklm"}));
    assertEquals(15, s17685.solution(new String[]{"word", "war", "warrior", "world"}));
  }
}
