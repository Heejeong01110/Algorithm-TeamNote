package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q1052Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q1052";

    testCorrect("3 3\n"
        + "1 6\n"
        + "13 17\n"
        + "8 12", "5");
  }


}
