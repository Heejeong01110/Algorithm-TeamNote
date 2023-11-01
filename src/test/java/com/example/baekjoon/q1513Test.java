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

class q1513Test {

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

    q1513 q = new q1513();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6 4 2\n"
        + "5 3\n"
        + "3 2", "14 24 0");
    testCorrect("5 5 3\n"
        + "1 3\n"
        + "2 4\n"
        + "3 5", "42 14 10 4 ");
    testCorrect("50 50 2\n"
        + "50 50\n"
        + "1 1", "0 0 0 ");

    testCorrect("3 3 2\n"
        + "2 2\n"
        + "3 2", "1 3 2 ");
  }
}
