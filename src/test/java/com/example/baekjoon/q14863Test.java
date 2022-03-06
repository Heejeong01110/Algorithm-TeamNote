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

public class q14863Test {

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

    q14863.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("""
        3 600
        500 150 200 1000
        100 835 200 324
        200 125 300 900""", "2735");
    testCorrect("""
        3 1650
        500 200 200 100
        800 370 300 120
        700 250 300 90""", "660");

    testCorrect("""
        4 3000
        1000 2000 300 700
        1100 1900 400 900
        900 1800 400 700
        1200 2300 500 1200""", "5900");
  }
}
