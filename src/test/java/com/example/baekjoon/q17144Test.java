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

class q17144Test {

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

    q17144 q = new q17144();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("7 8 1\n"
        + "0 0 0 0 0 0 0 9\n"
        + "0 0 0 0 3 0 0 8\n"
        + "-1 0 5 0 0 0 22 0\n"
        + "-1 8 0 0 0 0 0 0\n"
        + "0 0 0 0 0 10 43 0\n"
        + "0 0 5 0 15 0 0 0\n"
        + "0 0 40 0 0 0 20 0", "188");
    testCorrect("7 8 2\n"
        + "0 0 0 0 0 0 0 9\n"
        + "0 0 0 0 3 0 0 8\n"
        + "-1 0 5 0 0 0 22 0\n"
        + "-1 8 0 0 0 0 0 0\n"
        + "0 0 0 0 0 10 43 0\n"
        + "0 0 5 0 15 0 0 0\n"
        + "0 0 40 0 0 0 20 0", "188");
    testCorrect("7 8 3\n"
        + "0 0 0 0 0 0 0 9\n"
        + "0 0 0 0 3 0 0 8\n"
        + "-1 0 5 0 0 0 22 0\n"
        + "-1 8 0 0 0 0 0 0\n"
        + "0 0 0 0 0 10 43 0\n"
        + "0 0 5 0 15 0 0 0\n"
        + "0 0 40 0 0 0 20 0", "186");
    testCorrect("7 8 4\n"
        + "0 0 0 0 0 0 0 9\n"
        + "0 0 0 0 3 0 0 8\n"
        + "-1 0 5 0 0 0 22 0\n"
        + "-1 8 0 0 0 0 0 0\n"
        + "0 0 0 0 0 10 43 0\n"
        + "0 0 5 0 15 0 0 0\n"
        + "0 0 40 0 0 0 20 0", "178");
    testCorrect("7 8 5\n"
        + "0 0 0 0 0 0 0 9\n"
        + "0 0 0 0 3 0 0 8\n"
        + "-1 0 5 0 0 0 22 0\n"
        + "-1 8 0 0 0 0 0 0\n"
        + "0 0 0 0 0 10 43 0\n"
        + "0 0 5 0 15 0 0 0\n"
        + "0 0 40 0 0 0 20 0", "172");
    testCorrect("7 8 20\n"
        + "0 0 0 0 0 0 0 9\n"
        + "0 0 0 0 3 0 0 8\n"
        + "-1 0 5 0 0 0 22 0\n"
        + "-1 8 0 0 0 0 0 0\n"
        + "0 0 0 0 0 10 43 0\n"
        + "0 0 5 0 15 0 0 0\n"
        + "0 0 40 0 0 0 20 0", "71");
    testCorrect("7 8 30\n"
        + "0 0 0 0 0 0 0 9\n"
        + "0 0 0 0 3 0 0 8\n"
        + "-1 0 5 0 0 0 22 0\n"
        + "-1 8 0 0 0 0 0 0\n"
        + "0 0 0 0 0 10 43 0\n"
        + "0 0 5 0 15 0 0 0\n"
        + "0 0 40 0 0 0 20 0", "52");
    testCorrect("7 8 50\n"
        + "0 0 0 0 0 0 0 9\n"
        + "0 0 0 0 3 0 0 8\n"
        + "-1 0 5 0 0 0 22 0\n"
        + "-1 8 0 0 0 0 0 0\n"
        + "0 0 0 0 0 10 43 0\n"
        + "0 0 5 0 15 0 0 0\n"
        + "0 0 40 0 0 0 20 0", "46");
  }
}
