package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q16637Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q16637";

    testCorrect("1\n"
        + "1\n", "1");
    testCorrect("19\n"
        + "2*1-1*1+2*2-9*8-9*9\n", "189");
    testCorrect("3\n"
        + "1-3\n", "-2");
    testCorrect("17\n"
        + "1*1*1*1*1*1*2*1-2\n", "0");
    testCorrect("17\n"
        + "2*6+2-8-6+1*2-9*3\n", "63");
    testCorrect("17\n"
        + "2*6+2-8-6+1*2*9-3\n", "267");
    testCorrect("17\n"
        + "2*6+9-8*6+1*2*9-3\n", "2769");
    testCorrect("19\n"
        + "2*1-1*1+2*2-9*8-9*9\n", "189");
    testCorrect("9\n"
        + "3+8*7-9*2\n", "136");
    testCorrect("5\n"
        + "8*3+5\n", "64");
    testCorrect("7\n"
        + "8*3+5+2\n", "66");
    testCorrect("19\n"
        + "1*2+3*4*5-6*7*8*9*0\n", "0");
    testCorrect("19\n"
        + "1*2+3*4*5-6*7*8*9*9\n", "426384");
    testCorrect("19\n"
        + "1-9-1-9-1-9-1-9-1-9\n", "24");
  }


}
