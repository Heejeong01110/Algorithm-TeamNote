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

class q20058Test {

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

    q20058.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1\n", "284\n"
        + "64\n");
    testCorrect("3 2\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2\n", "280\n"
        + "64\n");
    testCorrect("3 5\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 0 3 2\n", "268\n"
        + "64\n");
    testCorrect("3 10\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 0 3 2 1 2 3 2 3\n", "248\n"
        + "62\n");
    testCorrect("3 10\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 8\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 1 2 3 1 2 3 1\n", "246\n"
        + "60\n");
    testCorrect("3 10\n"
        + "1 0 3 4 5 6 7 0\n"
        + "8 0 6 5 4 3 2 1\n"
        + "1 2 0 4 5 6 7 0\n"
        + "8 7 6 5 4 3 2 1\n"
        + "1 2 3 4 0 6 7 0\n"
        + "8 7 0 5 4 3 2 1\n"
        + "1 2 3 4 5 6 7 0\n"
        + "0 7 0 5 4 3 2 1\n"
        + "1 2 3 1 2 3 1 2 3 1\n", "37\n"
        + "9\n");
  }
}
