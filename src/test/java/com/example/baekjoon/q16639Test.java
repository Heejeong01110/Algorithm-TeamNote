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

class q16639Test {

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

    q16639 q = new q16639();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("19\n"
        + "1-9-1-9-1-9-1-9-1-9", "32");
    testCorrect("9\n"
        + "3+8*7-9*2", "136");
    testCorrect("5\n"
        + "8*3+5", "64");
    testCorrect("7\n"
        + "8*3+5+2", "80");
    testCorrect("19\n"
        + "1*2+3*4*5-6*7*8*9*0", "100");
    testCorrect("19\n"
        + "1*2+3*4*5-6*7*8*9*9", "426384");
  }
}
