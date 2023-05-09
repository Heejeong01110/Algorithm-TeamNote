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

class q14502Test {

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

    q14502 q = new q14502();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4 6\n"
        + "0 0 0 0 0 0\n"
        + "1 0 0 0 0 2\n"
        + "1 1 1 0 0 2\n"
        + "0 0 0 0 0 2", "9");
    testCorrect("8 8\n"
        + "2 0 0 0 0 0 0 2\n"
        + "2 0 0 0 0 0 0 2\n"
        + "2 0 0 0 0 0 0 2\n"
        + "2 0 0 0 0 0 0 2\n"
        + "2 0 0 0 0 0 0 2\n"
        + "0 0 0 0 0 0 0 0\n"
        + "0 0 0 0 0 0 0 0\n"
        + "0 0 0 0 0 0 0 0", "3");
    testCorrect("7 7\n"
        + "2 0 0 0 1 1 0\n"
        + "0 0 1 0 1 2 0\n"
        + "0 1 1 0 1 0 0\n"
        + "0 1 0 0 0 0 0\n"
        + "0 0 0 0 0 1 1\n"
        + "0 1 0 0 0 0 0\n"
        + "0 1 0 0 0 0 0", "27");
  }
}
