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

class q18428Test {

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

    q18428 q = new q18428();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5\n"
        + "X X S X X\n"
        + "X X X X X\n"
        + "S X T X S\n"
        + "X X X X X\n"
        + "X X S X X", "NO");
    testCorrect("5\n"
        + "X T X T X\n"
        + "T X S X T\n"
        + "X S S S X\n"
        + "T X S X X\n"
        + "X T X X X", "YES");
    testCorrect("5\n"
        + "X S S S X\n"
        + "T X X S X\n"
        + "X T X S X\n"
        + "X X T X S\n"
        + "X X X T X", "YES");

    testCorrect("5\n"
        + "X S X X T\n"
        + "T X S X X\n"
        + "X X X X X\n"
        + "X T X X X\n"
        + "X X T X X", "YES");
    testCorrect("4\n"
        + "S S S T\n"
        + "X X X X\n"
        + "X X X X\n"
        + "T T T X", "NO");
    testCorrect("4\n"
        + "X S X T\n"
        + "X X S X\n"
        + "X X X X\n"
        + "T T T X", "YES");
  }
}
