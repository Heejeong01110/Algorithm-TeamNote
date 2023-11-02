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

class q19238Test {

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

    q19238 q = new q19238();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6 3 15\n"
        + "0 0 1 0 0 0\n"
        + "0 0 1 0 0 0\n"
        + "0 0 0 0 0 0\n"
        + "0 0 0 0 0 0\n"
        + "0 0 0 0 1 0\n"
        + "0 0 0 1 0 0\n"
        + "6 5\n"
        + "2 2 5 6\n"
        + "5 4 1 6\n"
        + "4 2 3 5", "14");
    testCorrect("6 3 13\n"
        + "0 0 1 0 0 0\n"
        + "0 0 1 0 0 0\n"
        + "0 0 0 0 0 0\n"
        + "0 0 0 0 0 0\n"
        + "0 0 0 0 1 0\n"
        + "0 0 0 1 0 0\n"
        + "6 5\n"
        + "2 2 5 6\n"
        + "5 4 1 6\n"
        + "4 2 3 5", "-1");
    testCorrect("6 3 100\n"
        + "0 0 1 0 0 0\n"
        + "0 0 1 0 0 0\n"
        + "0 0 0 1 0 0\n"
        + "0 0 0 1 0 0\n"
        + "0 0 0 0 1 0\n"
        + "0 0 0 1 0 0\n"
        + "6 5\n"
        + "2 2 5 6\n"
        + "5 4 1 6\n"
        + "4 2 3 5", "-1");
  }
}
