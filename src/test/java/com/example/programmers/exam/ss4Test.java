package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ss4Test {
  @Test
  void solution() {
    assertArrayEquals(new String[]{"4", "3", "2"}, ss4.solution(3, new String[]{"1", "3", "2", "B", "4", "F"}));
    assertArrayEquals(new String[]{"3", "1", "2"}, ss4.solution(3, new String[]{"1", "2", "B", "B", "3"}));
    assertArrayEquals(new String[]{"2", "1"}, ss4.solution(3, new String[]{"1", "2", "B", "F"}));

    assertArrayEquals(new String[]{"5", "4", "3"}, ss4.solution(3, new String[]{"1", "2", "3", "4", "5"}));
    assertArrayEquals(new String[]{"3", "4", "2"}, ss4.solution(3, new String[]{"1", "2", "3", "4", "3"}));
    assertArrayEquals(new String[]{}, ss4.solution(1, new String[]{"B", "F"}));
  }
}
