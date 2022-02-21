package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s17677Test {

  @Test
  void solution() {
    assertEquals(16384, s17677.solution("FRANCE", "french"));
    assertEquals(65536, s17677.solution("handshake", "shake hands"));
    assertEquals(43690, s17677.solution("aa1+aa2", "AAAA12"));
    assertEquals(65536, s17677.solution("E=M*C^2", "e=m*c^2"));

  }
}
