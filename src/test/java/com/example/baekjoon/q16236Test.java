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

public class q16236Test {

  private static OutputStream out;
  private static InputStream in;

  @BeforeAll
  static void setting(){
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
  }

  private void testCorrect(String input, String output) throws IOException {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    q16236.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6\n"
        + "5 4 3 2 3 4\n"
        + "4 3 2 3 4 5\n"
        + "3 2 9 5 6 6\n"
        + "2 1 2 3 4 5\n"
        + "3 2 1 6 5 4\n"
        + "6 6 6 6 6 6", "60");
    testCorrect("6\n"
        + "6 0 6 0 6 1\n"
        + "0 0 0 0 0 2\n"
        + "2 3 4 5 6 6\n"
        + "0 0 0 0 0 2\n"
        + "0 2 0 0 0 0\n"
        + "3 9 3 0 0 1", "48");
    testCorrect("6\n"
        + "1 1 1 1 1 1\n"
        + "2 2 6 2 2 3\n"
        + "2 2 5 2 2 3\n"
        + "2 2 2 4 6 3\n"
        + "0 0 0 0 0 6\n"
        + "0 0 0 0 0 9", "39");

    testCorrect("3\n"
        + "0 0 0\n"
        + "0 0 0\n"
        + "0 9 0", "0");
    testCorrect("3\n"
        + "0 0 1\n"
        + "0 0 0\n"
        + "0 9 0", "3");
    testCorrect("4\n"
        + "4 3 2 1\n"
        + "0 0 0 0\n"
        + "0 0 9 0\n"
        + "1 2 3 4", "14");
  }
}
