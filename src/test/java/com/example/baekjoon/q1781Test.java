package com.example.baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class q1781Test {

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

    q1781.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3\n"
        + "3 9\n"
        + "3 4\n"
        + "1 1", "14");
    testCorrect("3\n"
        + "1 25\n"
        + "2 50\n"
        + "2 100", "150");
    testCorrect("7\n"
        + "1 6\n"
        + "1 7\n"
        + "3 2\n"
        + "3 1\n"
        + "2 4\n"
        + "2 5\n"
        + "6 1", "15");
  }
}
