package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s169199Test {

  @Test
  void solution() {
    s169199 question = new s169199();
    assertEquals(7,
        question.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    assertEquals(-1, question.solution(new String[]{".D.R", "....", ".G..", "...D"}));
  }
}
