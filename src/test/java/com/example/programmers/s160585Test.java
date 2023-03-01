package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s160585Test {

  @Test
  void solution() {
    assertEquals(0, s160585.solution(new String[]{
        "...",
        ".X.",
        "..."}));
    assertEquals(1, s160585.solution(new String[]{
        "O.X",
        ".O.",
        "..X"}));
    assertEquals(0, s160585.solution(new String[]{
        "OOO",
        "...",
        "XXX"}));
    assertEquals(1, s160585.solution(new String[]{
        "...",
        "...",
        "..."}));
  }
}
