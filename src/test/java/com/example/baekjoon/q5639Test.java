package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q5639Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q5639";

    testCorrect("50\n"
        + "30\n"
        + "24\n"
        + "5\n"
        + "28\n"
        + "45\n"
        + "98\n"
        + "52\n"
        + "60\n", "5\n"
        + "28\n"
        + "24\n"
        + "45\n"
        + "30\n"
        + "60\n"
        + "52\n"
        + "98\n"
        + "50\n");
  }


}
