package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q27497Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q27497";

    testCorrect("5\n"
        + "1 a\n"
        + "2 b\n"
        + "1 c\n"
        + "3\n"
        + "3\n", "a");
    testCorrect("9\n"
        + "1 c\n"
        + "2 n\n"
        + "1 h\n"
        + "1 o\n"
        + "2 i\n"
        + "1 R\n"
        + "3\n"
        + "2 S\n"
        + "1 n\n", "Sinchon");
    testCorrect("7\n"
        + "2 Y\n"
        + "3\n"
        + "1 R\n"
        + "3\n"
        + "3\n"
        + "2 n\n"
        + "2 O\n", "On");
    testCorrect("11\n"
        + "1 u\n"
        + "3\n"
        + "2 z\n"
        + "3\n"
        + "1 s\n"
        + "2 A\n"
        + "3\n"
        + "1 a\n"
        + "3\n"
        + "3\n"
        + "3\n", "0");
  }


}
