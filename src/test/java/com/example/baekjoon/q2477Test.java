package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q2477Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q2477";

    testCorrect("7\n"
        + "4 50\n"
        + "2 160\n"
        + "3 30\n"
        + "1 60\n"
        + "3 20\n"
        + "1 100\n", "47600");
  }

}
