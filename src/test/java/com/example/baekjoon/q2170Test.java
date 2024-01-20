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

class q2170Test {

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

    q2170 q = new q2170();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3\n"
        + "1 3\n"
        + "8 10\n"
        + "2 9", "9");
    testCorrect("3\n"
        + "1 4\n"
        + "2 3\n"
        + "3 5", "4");
    testCorrect("3\n"
        + "1 4\n"
        + "2 3\n"
        + "2 6", "5");
    testCorrect("5\n"
        + "0 2\n"
        + "0 3\n"
        + "0 1\n"
        + "0 5\n"
        + "0 7", "7");
    testCorrect("4\n"
        + "1 3\n"
        + "2 5\n"
        + "3 5\n"
        + "6 7", "5");
    testCorrect("3\n"
        + "-6 1\n"
        + "2 3\n"
        + "4 5", "9");
  }
}
