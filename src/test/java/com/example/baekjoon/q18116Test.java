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

public class q18116Test {

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

    q18116.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4\n"
        + "I 1 2\n"
        + "I 3 2\n"
        + "Q 1\n"
        + "Q 4", "3\n"
        + "1\n");
    testCorrect("5\n"
        + "I 1 2\n"
        + "I 3 2\n"
        + "I 1 3\n"
        + "Q 1\n"
        + "Q 4", "3\n"
        + "1\n");
    testCorrect("7\n"
        + "I 1 2\n"
        + "I 3 2\n"
        + "Q 1\n"
        + "I 4 5\n"
        + "I 4 6\n"
        + "I 1 4\n"
        + "Q 1\n", "3\n"
        + "6\n");
  }
}
