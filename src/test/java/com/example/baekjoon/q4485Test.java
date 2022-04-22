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

public class q4485Test {

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

    q4485.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3\n"
        + "5 5 4\n"
        + "3 9 1\n"
        + "3 2 7\n"
        + "5\n"
        + "3 7 2 0 1\n"
        + "2 8 0 9 1\n"
        + "1 2 1 8 1\n"
        + "9 8 9 2 0\n"
        + "3 6 5 1 5\n"
        + "7\n"
        + "9 0 5 1 1 5 3\n"
        + "4 1 2 1 6 5 3\n"
        + "0 7 6 1 6 8 5\n"
        + "1 1 7 8 3 2 3\n"
        + "9 4 0 7 6 4 1\n"
        + "5 8 3 2 4 8 3\n"
        + "7 4 8 4 8 3 4\n"
        + "0", "Problem 1: 20\n"
        + "Problem 2: 19\n"
        + "Problem 3: 36\n");
  }
}
