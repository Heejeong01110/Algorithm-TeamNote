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

class q16234Test {

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

    q16234 q = new q16234();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("2 20 50\n"
        + "50 30\n"
        + "20 40", "1");
    testCorrect("2 40 50\n"
        + "50 30\n"
        + "20 40", "0");
    testCorrect("2 20 50\n"
        + "50 30\n"
        + "30 40", "1");
    testCorrect("3 5 10\n"
        + "10 15 20\n"
        + "20 30 25\n"
        + "40 22 10", "2");
    testCorrect("4 10 50\n"
        + "10 100 20 90\n"
        + "80 100 60 70\n"
        + "70 20 30 40\n"
        + "50 20 100 10", "3");
  }
}
