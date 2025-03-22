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

class q1863Test {

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

    q1863.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6\n"
        + "1 2\n"
        + "2 5\n"
        + "3 7\n"
        + "4 3\n"
        + "5 5\n"
        + "6 3\n", "5");
    testCorrect("10\n"
        + "1 1\n"
        + "2 2\n"
        + "5 1\n"
        + "6 3\n"
        + "8 1\n"
        + "11 0\n"
        + "15 2\n"
        + "17 3\n"
        + "20 2\n"
        + "22 1\n", "6");
  }
}
