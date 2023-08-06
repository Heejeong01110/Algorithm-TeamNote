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

class q17780Test {

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

    q17780 q = new q17780();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
//    testCorrect("4 4\n"
//        + "0 0 2 0\n"
//        + "0 0 1 0\n"
//        + "0 0 1 2\n"
//        + "0 2 0 0\n"
//        + "2 1 1\n"
//        + "3 2 3\n"
//        + "2 2 1\n"
//        + "4 1 2", "-1");
//    testCorrect("4 4\n"
//        + "0 0 0 0\n"
//        + "0 0 0 0\n"
//        + "0 0 0 0\n"
//        + "0 0 0 0\n"
//        + "1 1 1\n"
//        + "1 2 1\n"
//        + "1 3 1\n"
//        + "1 4 1", "1");
//    testCorrect("4 4\n"
//        + "0 0 0 0\n"
//        + "0 0 0 0\n"
//        + "0 0 0 0\n"
//        + "0 0 0 0\n"
//        + "1 1 1\n"
//        + "1 2 1\n"
//        + "1 3 1\n"
//        + "2 4 3", "1");
//    testCorrect("4 4\n"
//        + "0 0 0 0\n"
//        + "0 0 0 0\n"
//        + "0 0 0 0\n"
//        + "0 0 0 0\n"
//        + "1 1 1\n"
//        + "1 2 1\n"
//        + "1 3 1\n"
//        + "3 3 3", "2");
//    testCorrect("4 4\n"
//        + "0 0 2 0\n"
//        + "0 0 1 0\n"
//        + "0 0 1 2\n"
//        + "0 2 0 0\n"
//        + "2 1 1\n"
//        + "3 2 3\n"
//        + "2 2 1\n"
//        + "4 1 3", "8");
    testCorrect("6 10\n"
        + "0 1 2 0 1 1\n"
        + "1 2 0 1 1 0\n"
        + "2 1 0 1 1 0\n"
        + "1 0 1 1 0 2\n"
        + "2 0 1 2 0 1\n"
        + "0 2 1 0 2 1\n"
        + "1 1 1\n"
        + "2 2 2\n"
        + "3 3 4\n"
        + "4 4 1\n"
        + "5 5 3\n"
        + "6 6 2\n"
        + "1 6 3\n"
        + "6 1 2\n"
        + "2 4 3\n"
        + "4 2 1", "9");
  }
}
