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

class q2533Test {

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

    q2533.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("8\n"
        + "1 2\n"
        + "1 3\n"
        + "1 4\n"
        + "2 5\n"
        + "2 6\n"
        + "4 7\n"
        + "4 8", "3");

    testCorrect("9\n"
        + "1 2\n"
        + "1 3\n"
        + "2 4\n"
        + "3 5\n"
        + "3 6\n"
        + "4 7\n"
        + "4 8\n"
        + "4 9", "3");

  }
}
