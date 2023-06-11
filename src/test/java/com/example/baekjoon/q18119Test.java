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

class q18119Test {

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

    q18119 q = new q18119();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 10\n"
        + "apple\n"
        + "actual\n"
        + "banana\n"
        + "brick\n"
        + "courts\n"
        + "1 l\n"
        + "1 b\n"
        + "1 c\n"
        + "1 n\n"
        + "2 l\n"
        + "2 b\n"
        + "1 s\n"
        + "2 c\n"
        + "2 s\n"
        + "2 n", "3\n"
        + "1\n"
        + "0\n"
        + "0\n"
        + "1\n"
        + "1\n"
        + "1\n"
        + "3\n"
        + "4\n"
        + "5");
  }
}
