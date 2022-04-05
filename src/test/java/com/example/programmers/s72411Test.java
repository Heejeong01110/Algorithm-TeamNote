package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s72411Test {

  @Test
  void solution() {
    assertArrayEquals(
        new String[]{"ACD", "AD", "ADE", "CD", "XYZ"},
        s72411.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
            new int[]{2, 3, 5}));
    assertArrayEquals(
        new String[]{"WX", "XY"},
        s72411.solution(new String[]{"XYZ", "XWY", "WXA"},
            new int[]{2, 3, 4}));
    assertArrayEquals(
        new String[]{"AC", "ACDE", "BCFG", "CDE"},
        s72411.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
            new int[]{2, 3, 4}));

  }
}
