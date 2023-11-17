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

class q16920Test {

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

    q16920 q = new q16920();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3 3 2\n"
        + "1 1\n"
        + "1..\n"
        + "...\n"
        + "..2", "6 3 ");
    testCorrect("3 3 2\n"
        + "1 1\n"
        + "1.1\n"
        + "...\n"
        + "..2", "7 2 ");
    testCorrect("4 4 2\n"
        + "1 1\n"
        + "1...\n"
        + "....\n"
        + "....\n"
        + "...2", "10 6 ");
    testCorrect("4 4 2\n"
        + "1 1\n"
        + "1..1\n"
        + "....\n"
        + "....\n"
        + "...2", "11 5 ");
    testCorrect("4 4 2\n"
        + "2 1\n"
        + "1..1\n"
        + "....\n"
        + "....\n"
        + "...2", "14 2 ");
    testCorrect("4 4 2\n"
        + "3 1\n"
        + "1..1\n"
        + "....\n"
        + "....\n"
        + "...2", "14 2 ");
    testCorrect("4 4 2\n"
        + "1 1\n"
        + "1..1\n"
        + "#.##\n"
        + "....\n"
        + "...2", "7 6 ");
    testCorrect("4 4 2\n"
        + "2 1\n"
        + "1..1\n"
        + "#.##\n"
        + "....\n"
        + "...2", "10 3 ");
    testCorrect("3 4 4\n"
        + "1 1 1 1\n"
        + "....\n"
        + "#...\n"
        + "1234", "1 4 3 3 ");
  }
}
