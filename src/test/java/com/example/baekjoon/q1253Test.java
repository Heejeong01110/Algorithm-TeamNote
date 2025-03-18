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

class q1253Test {

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

    q1253.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6\n"
        + "0 0 3 3 3 3", "4");
    testCorrect("7\n"
        + "0 0 0 3 3 3 3", "7");
    testCorrect("2\n"
        + "3 3", "0");
    testCorrect("4\n"
        + "0 -5 5 5", "3");
    testCorrect("3\n"
        + "0 -5 5", "1");
    testCorrect("4\n"
        + "500000000 -500000000 500000000 1000000000", "3");
    testCorrect("10\n"
        + "1 2 3 4 5 6 7 8 9 10", "8");
  }
}
