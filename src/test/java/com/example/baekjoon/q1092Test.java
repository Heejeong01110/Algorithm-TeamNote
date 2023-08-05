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

class q1092Test {

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

    q1092 q = new q1092();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {

    testCorrect("3\n"
        + "10 6 5\n"
        + "11\n"
        + "6 8 9 6 8 6 9 6 8 6 9", "6");
    testCorrect("4\n"
        + "1 2 3 4\n"
        + "8\n"
        + "1 1 2 2 3 3 4 4", "2");
    testCorrect("3\n"
        + "10 7 4\n"
        + "9\n"
        + "9 9 8 7 6 6 5 5 2", "4");
    testCorrect("3\n"
        + "1 2 3\n"
        + "4\n"
        + "1 2 3 4", "-1");


    testCorrect("4\n"
        + "23 32 25 28\n"
        + "10\n"
        + "5 27 10 16 24 20 2 32 18 7", "3");
    testCorrect("10\n"
        + "11 17 5 2 20 7 5 5 20 7\n"
        + "5\n"
        + "18 18 15 15 17", "2");
    testCorrect("3\n"
        + "6 8 9\n"
        + "5\n"
        + "2 5 2 4 7", "2");
    testCorrect("2\n"
        + "19 20\n"
        + "7\n"
        + "14 12 16 19 16 1 5", "4");
  }
}
