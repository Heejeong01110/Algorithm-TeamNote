package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import com.example.programmers.exam.ss3;
import org.junit.jupiter.api.Test;

class s70129Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{3,8}, s70129.solution("110010101001"));
    assertArrayEquals(new int[]{3,3}, s70129.solution("01110"));
    assertArrayEquals(new int[]{4,1}, s70129.solution("1111111"));
    }
}
