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

public class q17471Test {

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

    q17471.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("""
        6
        2 3 4 5 6 7
        2 2 3
        2 1 3
        2 1 2
        2 5 6
        2 4 6
        2 4 5""", "9");
    testCorrect("""
        6
        5 2 3 4 1 2
        2 2 4
        4 1 3 6 5
        2 4 2
        2 1 3
        1 2
        1 2""", "1");

    testCorrect("""
        6
        1 1 1 1 1 1
        2 2 4
        4 1 3 6 5
        2 4 2
        2 1 3
        1 2
        1 2""", "0");
    testCorrect("""
        6
        10 20 10 20 30 40
        0
        0
        0
        0
        0
        0""", "-1");
  }
}
