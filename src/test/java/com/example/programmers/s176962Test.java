package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s176962Test {

  @Test
  void solution() {
    s176962 question = new s176962();
    assertArrayEquals(new String[]{"science", "history", "computer", "music"}, question.solution(
        new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"},
            {"history", "14:00", "30"}, {"computer", "12:30", "100"}}));
    assertArrayEquals(new String[]{"bbb", "ccc", "aaa"}, question.solution(
        new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}}));
    assertArrayEquals(new String[]{"korean", "english", "math"}, question.solution(
        new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"},
            {"math", "12:30", "40"}}));
  }
}
