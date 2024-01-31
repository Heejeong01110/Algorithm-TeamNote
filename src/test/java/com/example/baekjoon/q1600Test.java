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

class q1600Test {

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

    q1600 q = new q1600();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("1\n"
        + "1 1\n"
        + "0", "0");
    testCorrect("2\n"
        + "10 2\n"
        + "0 0 1 0 0 1 0 0 1 0\n"
        + "0 0 1 1 0 0 0 0 1 0", "10");
    testCorrect("1\n"
        + "4 4\n"
        + "0 0 0 0\n"
        + "1 0 0 0\n"
        + "0 0 1 0\n"
        + "0 1 0 0", "4");
    testCorrect("2\n"
        + "5 2\n"
        + "0 0 1 1 0\n"
        + "0 0 1 1 0", "-1");
  }
}
