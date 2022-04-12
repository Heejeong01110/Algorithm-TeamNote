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

class q13397Test {

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

    q13397.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 2\n"
        + "1 100 99 2 3", "98");
    testCorrect("5 3\n"
        + "1 100 99 2 3", "1");
    testCorrect("8 3\n"
        + "1 5 4 6 2 1 3 7", "5");
    testCorrect("4 2\n"
        + "1 1 1 1", "0");
    testCorrect("7 4\n"
        + "1 2 3 1 2 3 1", "2");
    testCorrect("5 1\n"
        + "1 100 99 2 3", "99");
  }
}
