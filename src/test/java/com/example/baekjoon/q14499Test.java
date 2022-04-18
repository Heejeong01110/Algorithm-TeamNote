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

public class q14499Test {

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

    q14499.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4 2 0 0 8\n"
        + "0 2\n"
        + "3 4\n"
        + "5 6\n"
        + "7 8\n"
        + "4 4 4 1 3 3 3 2", "0\n"
        + "0\n"
        + "3\n"
        + "0\n"
        + "0\n"
        + "8\n"
        + "6\n"
        + "3\n");
    testCorrect("3 3 1 1 9\n"
        + "1 2 3\n"
        + "4 0 5\n"
        + "6 7 8\n"
        + "1 3 2 2 4 4 1 1 3", "0\n"
        + "0\n"
        + "0\n"
        + "3\n"
        + "0\n"
        + "1\n"
        + "0\n"
        + "6\n"
        + "0\n");
    testCorrect("2 2 0 0 16\n"
        + "0 2\n"
        + "3 4\n"
        + "4 4 4 4 1 1 1 1 3 3 3 3 2 2 2 2", "0\n"
        + "0\n"
        + "0\n"
        + "0\n");
    testCorrect("3 3 0 0 16\n"
        + "0 1 2\n"
        + "3 4 5\n"
        + "6 7 8\n"
        + "4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2", "0\n"
        + "0\n"
        + "0\n"
        + "6\n"
        + "0\n"
        + "8\n"
        + "0\n"
        + "2\n"
        + "0\n"
        + "8\n"
        + "0\n"
        + "2\n"
        + "0\n"
        + "8\n"
        + "0\n"
        + "2\n");
  }
}
