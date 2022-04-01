package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s92341Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{14600, 34400, 5000},
        s92341.solution(new int[]{180, 5000, 10, 600},
        new String[]{
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"}));
    assertArrayEquals(new int[]{0, 591}, s92341.solution(new int[]{120, 0, 60, 591},
        new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT",
            "23:58 3961 IN"}));
    assertArrayEquals(new int[]{14841}, s92341.solution(new int[]{1, 461, 1, 10},
        new String[]{"00:00 1234 IN"}));
  }
}
