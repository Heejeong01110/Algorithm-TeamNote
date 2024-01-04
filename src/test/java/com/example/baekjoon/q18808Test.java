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

class q18808Test {

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

    q18808 q = new q18808();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 4 4\n"
        + "3 3\n"
        + "1 0 1\n"
        + "1 1 1\n"
        + "1 0 1\n"
        + "2 5\n"
        + "1 1 1 1 1\n"
        + "0 0 0 1 0\n"
        + "2 3\n"
        + "1 1 1\n"
        + "1 0 1\n"
        + "3 3\n"
        + "1 0 0\n"
        + "1 1 1\n"
        + "1 0 0", "18");
    testCorrect("1 3 3\n"
        + "2 3\n"
        + "1 0 0\n"
        + "1 1 1\n"
        + "1 1\n"
        + "1\n"
        + "3 1\n"
        + "1\n"
        + "1\n"
        + "1", "1");
    testCorrect("2 3 3\n"
        + "2 3\n"
        + "1 1 1\n"
        + "1 0 0\n"
        + "2 1\n"
        + "1\n"
        + "1\n"
        + "2 2\n"
        + "1 0\n"
        + "1 1", "6");
    testCorrect("4 5 4\n"
        + "3 3\n"
        + "1 0 1\n"
        + "1 1 1\n"
        + "0 1 0\n"
        + "2 4\n"
        + "1 1 1 1\n"
        + "0 1 0 1\n"
        + "1 4\n"
        + "1 1 1 1\n"
        + "4 2\n"
        + "1 0\n"
        + "1 1\n"
        + "0 1\n"
        + "0 1", "17");
    testCorrect("2 2 3\n"
        + "3 1\n"
        + "1\n"
        + "1\n"
        + "1\n"
        + "2 3\n"
        + "1 0 1\n"
        + "1 1 1\n"
        + "2 4\n"
        + "1 0 1 1\n"
        + "1 1 1 0", "0");
    testCorrect("6 7 5\n"
        + "4 6\n"
        + "1 0 0 1 0 1\n"
        + "1 1 0 1 0 1\n"
        + "1 1 1 1 1 1\n"
        + "0 0 0 1 0 0\n"
        + "4 3\n"
        + "0 1 0\n"
        + "1 1 1\n"
        + "0 1 1\n"
        + "1 1 0\n"
        + "3 6\n"
        + "1 1 1 1 1 1\n"
        + "0 0 1 0 0 0\n"
        + "0 0 1 0 0 0\n"
        + "6 6\n"
        + "0 0 1 1 0 0\n"
        + "1 1 1 1 0 1\n"
        + "0 0 1 1 1 1\n"
        + "0 0 1 1 1 1\n"
        + "1 1 1 0 1 1\n"
        + "0 1 0 0 1 0\n"
        + "4 4\n"
        + "1 1 1 1\n"
        + "0 0 0 1\n"
        + "0 0 1 1\n"
        + "0 0 0 1", "30");
    testCorrect("6 8 3\n"
        + "4 5\n"
        + "0 0 1 1 1\n"
        + "1 1 1 0 1\n"
        + "0 0 1 0 1\n"
        + "0 0 1 0 0\n"
        + "5 4\n"
        + "0 0 1 0\n"
        + "1 1 1 1\n"
        + "1 1 0 1\n"
        + "1 1 0 0\n"
        + "1 1 0 0\n"
        + "5 6\n"
        + "0 0 1 1 1 1\n"
        + "1 1 1 1 0 0\n"
        + "1 1 1 1 1 0\n"
        + "0 1 0 1 0 0\n"
        + "0 1 0 1 0 0", "22");
    testCorrect("8 6 6\n"
        + "3 5\n"
        + "0 1 0 0 0\n"
        + "1 1 1 1 1\n"
        + "0 1 0 0 1\n"
        + "6 3\n"
        + "0 0 1\n"
        + "0 0 1\n"
        + "0 0 1\n"
        + "1 1 1\n"
        + "1 0 1\n"
        + "1 1 1\n"
        + "6 3\n"
        + "1 1 0\n"
        + "1 0 0\n"
        + "1 1 1\n"
        + "1 0 1\n"
        + "1 0 0\n"
        + "1 0 0\n"
        + "6 6\n"
        + "0 0 0 0 1 0\n"
        + "0 0 1 0 1 0\n"
        + "0 0 1 0 1 0\n"
        + "0 1 1 1 1 0\n"
        + "0 1 1 0 1 1\n"
        + "1 1 1 0 0 0\n"
        + "4 5\n"
        + "0 0 0 0 1\n"
        + "1 0 0 1 1\n"
        + "1 1 1 1 0\n"
        + "1 1 0 1 0\n"
        + "4 3\n"
        + "1 1 0\n"
        + "1 0 0\n"
        + "1 1 1\n"
        + "1 1 1", "29");
  }
}
