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

class q3190Test {

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

    q3190 question = new q3190();
    question.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("10\n"
        + "4\n"
        + "1 2\n"
        + "1 3\n"
        + "1 4\n"
        + "1 5\n"
        + "4\n"
        + "8 D\n"
        + "10 D\n"
        + "11 D\n"
        + "13 L", "21");
    testCorrect("10\n"
        + "5\n"
        + "1 5\n"
        + "1 3\n"
        + "1 2\n"
        + "1 6\n"
        + "1 7\n"
        + "4\n"
        + "8 D\n"
        + "10 D\n"
        + "11 D\n"
        + "13 L", "13");
    testCorrect("6\n"
        + "3\n"
        + "3 4\n"
        + "2 5\n"
        + "5 3\n"
        + "3\n"
        + "3 D\n"
        + "15 L\n"
        + "17 D", "9");
  }
}
