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

class q1082Test {

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

    q1082.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
//    testCorrect("3\n"
//        + "6 7 8\n"
//        + "21\n", "210");
    testCorrect("3\n"
        + "5 23 24\n"
        + "30\n", "20");
    testCorrect("4\n"
        + "1 5 3 2\n"
        + "1\n", "0");
    testCorrect("10\n"
        + "1 1 1 1 1 1 1 1 1 1\n"
        + "50\n", "99999999999999999999999999999999999999999999999999");
  }
}
