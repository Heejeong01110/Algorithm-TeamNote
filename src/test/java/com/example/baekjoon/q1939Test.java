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

class q1939Test {

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

    q1939 q = new q1939();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("9 9\n"
        + "1 4 11\n"
        + "1 5 2\n"
        + "4 5 4\n"
        + "4 3 10\n"
        + "4 2 7\n"
        + "5 2 10\n"
        + "5 6 13\n"
        + "3 2 9\n"
        + "2 6 8\n"
        + "1 6", "9");
    testCorrect("3 3\n"
        + "1 2 2\n"
        + "3 1 3\n"
        + "2 3 2\n"
        + "1 3", "3");
  }
}
