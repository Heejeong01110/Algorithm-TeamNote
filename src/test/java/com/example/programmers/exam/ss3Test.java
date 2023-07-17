package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ss3Test {

  @Test
  void solution() {
    assertArrayEquals(new String[]{"토스커피사일로&베이커리", "비바리퍼블리카 식당"}, ss3.solution(
        new String[]{"비바리퍼블리", "토스커피사일로 베이커리", "비바리퍼블리카 식당", "토스커피사일", "토스커피사일로 베이커", "비바리퍼블리카식",
            "토스커피사일로 베이", "토스커피사일로&베이커리"}));
    assertArrayEquals(new String[]{"토스커피사일로&베이커리"}, ss3.solution(
        new String[]{"토스커피사일로 베이커리", "토스커피사일", "토스커피사일로 베이커", "토스커피사일로 베이", "토스커피사일로&베이커리"}));
  }
}
