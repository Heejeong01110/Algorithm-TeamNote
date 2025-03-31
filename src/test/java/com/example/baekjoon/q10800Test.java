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

class q10800Test {

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

    q10800.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4\n"
        + "1 10\n"
        + "3 15\n"
        + "1 3\n"
        + "4 8\n", "8\n"
        + "21\n"
        + "0\n"
        + "3");
    testCorrect("3\n"
        + "2 3\n"
        + "2 5\n"
        + "2 4\n", "0\n"
        + "0\n"
        + "0");
    testCorrect("3\n"
        + "1 1\n"
        + "1 1\n"
        + "1 1\n", "0\n"
        + "0\n"
        + "0");
  }
}
