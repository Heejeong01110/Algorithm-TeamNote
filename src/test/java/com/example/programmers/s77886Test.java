package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s77886Test {

  @Test
  void solution() {

    assertArrayEquals(new String[]{"0110110111", "1101", "100110110"},
        s77886.solution(new String[]{"0111111010", "1110", "100111100"}));
  }
}
