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

class q2339Test {

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

    q2339.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("8\n"
        + "0 0 0 0 0 2 0 0\n"
        + "0 0 0 0 0 0 1 0\n"
        + "0 0 2 1 0 0 2 0\n"
        + "0 1 0 0 0 0 0 0\n"
        + "0 0 0 0 0 0 0 0\n"
        + "0 0 0 2 1 0 0 0\n"
        + "0 0 0 0 0 0 2 0\n"
        + "0 0 0 0 0 0 0 0\n", "1");
    testCorrect("5\n"
        + "0 0 0 0 0\n"
        + "0 2 2 0 0\n"
        + "0 1 1 1 0\n"
        + "0 2 1 2 0\n"
        + "2 0 0 0 0\n", "-1");
  }
}
