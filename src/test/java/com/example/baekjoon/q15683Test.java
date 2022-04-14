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

public class q15683Test {

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

    q15683.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("1 7\n"
        + "0 1 2 3 4 5 6", "0");
    testCorrect("3 7\n"
        + "4 0 0 0 0 0 0\n"
        + "0 0 0 2 0 0 0\n"
        + "0 0 0 0 0 0 4", "0");

    testCorrect("4 6\n"
        + "0 0 0 0 0 0\n"
        + "0 0 0 0 0 0\n"
        + "0 0 1 0 6 0\n"
        + "0 0 0 0 0 0", "20");
    testCorrect("6 6\n"
        + "0 0 0 0 0 0\n"
        + "0 2 0 0 0 0\n"
        + "0 0 0 0 6 0\n"
        + "0 6 0 0 2 0\n"
        + "0 0 0 0 0 0\n"
        + "0 0 0 0 0 5", "15");
    testCorrect("6 6\n"
        + "1 0 0 0 0 0\n"
        + "0 1 0 0 0 0\n"
        + "0 0 1 0 0 0\n"
        + "0 0 0 1 0 0\n"
        + "0 0 0 0 1 0\n"
        + "0 0 0 0 0 1", "6");
    testCorrect("6 6\n"
        + "1 0 0 0 0 0\n"
        + "0 1 0 0 0 0\n"
        + "0 0 1 5 0 0\n"
        + "0 0 5 1 0 0\n"
        + "0 0 0 0 1 0\n"
        + "0 0 0 0 0 1", "2");
  }
}
