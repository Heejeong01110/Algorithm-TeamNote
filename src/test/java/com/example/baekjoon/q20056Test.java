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

class q20056Test {

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

    q20056.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4 2 1\n"
        + "1 1 5 2 2\n"
        + "1 4 7 1 6\n", "8");
    testCorrect("4 2 2\n"
        + "1 1 5 2 2\n"
        + "1 4 7 1 6\n", "8");
    testCorrect("4 2 3\n"
        + "1 1 5 2 2\n"
        + "1 4 7 1 6\n", "0");
    testCorrect("7 5 3\n"
        + "1 3 5 2 4\n"
        + "2 3 5 2 6\n"
        + "5 2 9 1 7\n"
        + "6 2 1 3 5\n"
        + "4 4 2 4 2\n", "9");
    testCorrect("4 9 5\n"
        + "3 2 8 5 2\n"
        + "3 3 19 3 4\n"
        + "3 1 7 1 1\n"
        + "4 4 6 4 0\n"
        + "2 1 6 2 5\n"
        + "4 3 9 4 3\n"
        + "2 2 16 1 2\n"
        + "4 2 17 5 3\n"
        + "3 4 3 5 7\n", "33");
    testCorrect("4 6 4\n"
        + "1 1 5 1 1\n"
        + "3 3 5 1 5\n"
        + "1 3 5 1 3\n"
        + "3 1 5 1 7\n"
        + "2 2 5 1 3\n"
        + "3 2 5 1 2\n", "4");
  }
}
