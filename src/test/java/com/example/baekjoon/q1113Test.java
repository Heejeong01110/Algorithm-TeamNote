package com.example.baekjoon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class q1113Test {

  private static OutputStream out;
  private static InputStream in;

  @BeforeAll
  static void setting() {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
  }

  private void testCorrect(String input, String output) throws IOException {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    q1113 q = new q1113();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3 5\n"
        + "16661\n"
        + "61116\n"
        + "16661", "15");
    testCorrect("5 9\n"
        + "111111111\n"
        + "115111611\n"
        + "131516161\n"
        + "115111611\n"
        + "111111111", "7");
    testCorrect("9 13\n"
        + "1111111111111\n"
        + "1555555555551\n"
        + "1511111111151\n"
        + "1511199911151\n"
        + "1511192911151\n"
        + "1511199911151\n"
        + "1511111111151\n"
        + "1555555555551\n"
        + "1111111111111", "151");

    testCorrect("4 6\n"
        + "999999\n"
        + "955119\n"
        + "955119\n"
        + "999999", "48");
  }
}
