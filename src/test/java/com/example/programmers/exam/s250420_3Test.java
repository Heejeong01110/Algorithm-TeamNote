package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s250420_3Test {

  @Test
  void solution() {
//    assertEquals(21,
//        s250420_3.solution(10, 1, new String[][]{{"A", "B", "C", "D"}, {"X", "Y", "B", "Z"}},
//            new String[]{"A", "B", "Z"}));

    assertEquals(40,
        s250420_3.solution(10, 1, new String[][]{{"A", "B", "C", "D"}, {"X", "Y", "B", "Z"}},
            new String[]{"X", "Z", "B", "Y"}));

  }

}
