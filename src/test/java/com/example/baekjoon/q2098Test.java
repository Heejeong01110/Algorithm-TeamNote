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

class q2098Test {

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

    q2098 q = new q2098();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4\n"
        + "0 10 15 20\n"
        + "5 0 9 10\n"
        + "6 13 0 12\n"
        + "8 8 9 0", "35");
  }
}
