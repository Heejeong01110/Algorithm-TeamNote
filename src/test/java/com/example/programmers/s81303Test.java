package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s81303Test {

  @Test
  void solution() {
    assertEquals("OOXOXOOO",s81303.solution(8,2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    assertEquals("OOOOXOOO",s81303.solution(8,2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
  }
}
