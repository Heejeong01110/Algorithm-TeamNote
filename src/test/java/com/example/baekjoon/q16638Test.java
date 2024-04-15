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

class q16638Test {

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

    q16638 q = new q16638();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("9\n"
        + "3+8*7-9*2", "59");
    testCorrect("5\n"
        + "8*3+5", "64");
    testCorrect("7\n"
        + "8*3+5+2", "66");
    testCorrect("19\n"
        + "1*2+3*4*5-6*7*8*9*0", "100");
    testCorrect("19\n"
        + "1*2+3*4*5-6*7*8*9*9", "-27116");
    testCorrect("19\n"
        + "1-9-1-9-1-9-1-9-1-9", "24");
  }
}
