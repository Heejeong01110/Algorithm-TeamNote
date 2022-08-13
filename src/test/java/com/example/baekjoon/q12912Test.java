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

class q12912Test {

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

    q12912.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("2\n"
        + "0 1 2", "2");
    testCorrect("4\n"
        + "0 1 2\n"
        + "0 2 4\n"
        + "0 3 8", "14");
    testCorrect("5\n"
        + "0 1 1\n"
        + "1 2 2\n"
        + "2 3 3\n"
        + "3 4 4", "10");
    testCorrect("12\n"
        + "0 1 100\n"
        + "1 2 1000\n"
        + "0 3 100\n"
        + "3 4 1000\n"
        + "0 5 1\n"
        + "6 5 10\n"
        + "7 5 10\n"
        + "7 8 10\n"
        + "8 9 10\n"
        + "9 10 100\n"
        + "11 9 100", "2410");
    testCorrect("9\n"
        + "1 6 1\n"
        + "5 6 1\n"
        + "6 4 1\n"
        + "4 8 1\n"
        + "4 0 1\n"
        + "0 3 1\n"
        + "3 2 1\n"
        + "3 7 1", "7");
  }
}
