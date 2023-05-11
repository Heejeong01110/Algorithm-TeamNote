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

class q14890Test {

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

    q14890.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6 2\n"
        + "3 3 3 3 3 3\n"
        + "2 3 3 3 3 3\n"
        + "2 2 2 3 2 3\n"
        + "1 1 1 2 2 2\n"
        + "1 1 1 3 3 1\n"
        + "1 1 2 3 3 2", "3");
    testCorrect("6 2\n"
        + "3 2 1 1 2 3\n"
        + "3 2 2 1 2 3\n"
        + "3 2 2 2 3 3\n"
        + "3 3 3 3 3 3\n"
        + "3 3 3 3 2 2\n"
        + "3 3 3 3 2 2", "7");
    testCorrect("6 3\n"
        + "3 2 1 1 2 3\n"
        + "3 2 2 1 2 3\n"
        + "3 2 2 2 3 3\n"
        + "3 3 3 3 3 3\n"
        + "3 3 3 3 2 2\n"
        + "3 3 3 3 2 2", "3");
    testCorrect("6 1\n"
        + "3 2 1 1 2 3\n"
        + "3 2 2 1 2 3\n"
        + "3 2 2 2 3 3\n"
        + "3 3 3 3 3 3\n"
        + "3 3 3 3 2 2\n"
        + "3 3 3 3 2 2", "11");
  }
}
