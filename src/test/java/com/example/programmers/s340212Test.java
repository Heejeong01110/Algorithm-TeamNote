package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s340212Test {

  @Test
  void solution() {
    assertEquals(1, s340212.solution(new int[]{1,1,3}, new int[]{1,1,3}, 50));
    assertEquals(3, s340212.solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30));
    assertEquals(2, s340212.solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59));
    assertEquals(294,
        s340212.solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723));
    assertEquals(39354,
        s340212.solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001},
            Long.parseLong("3456789012")));
  }
}
