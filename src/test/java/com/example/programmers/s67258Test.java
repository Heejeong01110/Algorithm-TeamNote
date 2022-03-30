package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s67258Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{2, 3}, s67258.solution(
        new String[]{"A", "A", "B"}));
    assertArrayEquals(new int[]{1, 5}, s67258.solution(
        new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}));
    assertArrayEquals(new int[]{3, 7}, s67258.solution(
        new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
    assertArrayEquals(new int[]{1, 3}, s67258.solution(
        new String[]{"AA", "AB", "AC", "AA", "AC"}));
    assertArrayEquals(new int[]{1, 1}, s67258.solution(
        new String[]{"XYZ", "XYZ", "XYZ"}));


  }
}
