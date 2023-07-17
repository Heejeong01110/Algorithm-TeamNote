package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s67260Test {

  @Test
  void solution() {
//    assertEquals(true, s67260.solution(10,
//        new int[][]{{8, 1}, {0, 1}, {1, 2}, {0, 7}, {4, 7}, {0, 3}, {7, 5}, {3, 6}, {2, 9}},
//        new int[][]{{4, 1}, {5, 9}}));
    assertEquals(true, s67260.solution(9,
        new int[][]{{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}},
        new int[][]{{8, 5}, {6, 7}, {4, 1}}));
    assertEquals(true, s67260.solution(9,
        new int[][]{{8, 1}, {0, 1}, {1, 2}, {0, 7}, {4, 7}, {0, 3}, {7, 5}, {3, 6}},
        new int[][]{{4, 1}, {5, 2}}));
    assertEquals(false, s67260.solution(9,
        new int[][]{{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}},
        new int[][]{{4, 1}, {8, 7}, {6, 5}}));
  }
}
