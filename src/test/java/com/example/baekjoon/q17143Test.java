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

public class q17143Test {

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

    q17143.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4 6 8\n"
        + "4 1 3 3 8\n"
        + "1 3 5 2 9\n"
        + "2 4 8 4 1\n"
        + "4 5 0 1 4\n"
        + "3 3 1 2 7\n"
        + "1 5 8 4 3\n"
        + "3 6 2 1 2\n"
        + "2 2 2 3 5", "22");
    testCorrect("100 100 0", "0");
    testCorrect("4 5 4\n"
        + "4 1 3 3 8\n"
        + "1 3 5 2 9\n"
        + "2 4 8 4 1\n"
        + "4 5 0 1 4", "22");
    testCorrect("2 2 4\n"
        + "1 1 1 1 1\n"
        + "2 2 2 2 2\n"
        + "1 2 1 2 3\n"
        + "2 1 2 1 4", "4");
  }
}
