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

class q13458Test {

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

    q13458.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3\n"
        + "3 4 5\n"
        + "2 2", "7");
    testCorrect("5\n"
        + "1000000 1000000 1000000 1000000 1000000\n"
        + "5 7", "714290");
    testCorrect("5\n"
        + "10 9 10 9 10\n"
        + "7 20", "10");
    testCorrect("5\n"
        + "10 9 10 9 10\n"
        + "7 2", "13");
    testCorrect("1\n"
        + "1\n"
        + "1 1", "1");
  }
}
