package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class s159993Test {

  @Test
  void solution() {
    s159993 question = new s159993();
    assertEquals(16, question.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    assertEquals(-1, question.solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));

  }
}
