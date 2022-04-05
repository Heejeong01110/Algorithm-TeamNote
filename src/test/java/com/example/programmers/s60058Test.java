package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s60058Test {

  @Test
  void solution() {
    assertEquals("(()())()",s60058.solution("(()())()"));
    assertEquals("()",s60058.solution(")("));
    assertEquals("()(())()",s60058.solution("()))((()"));

  }
}
