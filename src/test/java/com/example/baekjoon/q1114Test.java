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

class q1114Test {

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

    q1114.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("10 4 3\n"
        + "1 2 3 9", "6 1");
    testCorrect("10 4 2\n"
        + "1 4 5 10", "5 1");
    testCorrect("9 9 2\n"
        + "1 2 3 4 5 6 7 8 9", "3 3");
    testCorrect("10 4 2\n"
        + "9 8 2 1", "6 2");
    testCorrect("9 2 1\n"
        + "4 5", "5 4");
    testCorrect("5 1 2\n"
        + "3", "3 3");
    testCorrect("5 5 3\n"
        + "4 2 5 3 1", "2 1");
    testCorrect("5 10 10\n"
        + "4 3 2 1 4 3 2 1 4 3", "1 1");
  }
}
