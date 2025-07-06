package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q2504Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q2504";

    testCorrect("(()[[]])([])", "28");
    testCorrect("[][]((])", "0");
  }


}
