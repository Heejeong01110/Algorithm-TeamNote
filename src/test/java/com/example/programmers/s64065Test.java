package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s64065Test {

  @Test
  void solution() {
    s64065 question = new s64065();
    assertArrayEquals(new int[]{2, 1, 3, 4}, question.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    assertArrayEquals(new int[]{2, 1, 3, 4}, question.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    assertArrayEquals(new int[]{111, 20}, question.solution("{{20,111},{111}}"));
    assertArrayEquals(new int[]{123}, question.solution("{{123}}"));
    assertArrayEquals(new int[]{3, 2, 4, 1}, question.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
  }
}
