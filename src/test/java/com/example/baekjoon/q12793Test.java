package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q12793Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q12793";

    testCorrect("9 4 2\n"
        + "+-+-+-+-+-+-+-+-+-+\n"
        + "|B.B|O|B|O|B.B.B|B|\n"
        + "+-+.+-+-+-+-+-+-+-+\n"
        + "|O|B.B|O|B.B|O|B.B|\n"
        + "+-+-+-+-+-+.+-+-+-+\n"
        + "|B|O|B.B.B|B|B.B.B|\n"
        + "+-+-+-+-+-+-+-+-+-+\n"
        + "|O|O|O|O|O|O|O|O|O|\n"
        + "+-+-+-+-+-+-+-+-+-+", "3");
    testCorrect("3 3 2.5\n"
        + "+-+-+-+\n"
        + "|O|B.B|\n"
        + "+-+-+-+\n"
        + "|B|O|O|\n"
        + "+-+-+-+\n"
        + "|B|B.B|\n"
        + "+-+-+-+", "3");
  }

}
