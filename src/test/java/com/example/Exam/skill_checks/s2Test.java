package com.example.Exam.skill_checks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s2Test {

  @Test
  void solution() {
    assertEquals(7, s2.solution(
        new int[][]{
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0}}));

  }
}
