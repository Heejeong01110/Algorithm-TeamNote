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

class q2515Test {

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

    q2515.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6 4\n"
        + "15 80\n"
        + "8 230\n"
        + "10 100\n"
        + "17 200\n"
        + "20 75\n"
        + "26 80", "510");
    testCorrect("9 3\n"
        + "8 30\n"
        + "5 10\n"
        + "14 50\n"
        + "12 80\n"
        + "8 20\n"
        + "16 50\n"
        + "11 60\n"
        + "15 40\n"
        + "10 50", "170");
  }
}
