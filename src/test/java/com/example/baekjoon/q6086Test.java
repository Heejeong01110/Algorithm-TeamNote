package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q6086Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q6086";

    testCorrect("5\n"
        + "A B 3\n"
        + "B C 3\n"
        + "C D 5\n"
        + "D Z 4\n"
        + "B Z 6\n", "3");
  }


}
