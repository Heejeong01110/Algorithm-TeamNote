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

public class q15664Test {

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

    q15664.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect(
        "8 8\n"
            + "1 2 3 4 5 6 7 8",
        "1 2 3 4 5 6 7 8\r\n");

    testCorrect(
        "8 7\n"
            + "2 2 4 4 5 6 7 8",
        "2 2 4 4 5 6 7\r\n"
            + "2 2 4 4 5 6 8\r\n"
            + "2 2 4 4 5 7 8\r\n"
            + "2 2 4 4 6 7 8\r\n"
            + "2 2 4 5 6 7 8\r\n"
            + "2 4 4 5 6 7 8\r\n");

    testCorrect(
        "4 2\n"
            + "999 1 23 5",
        "1 5\r\n"
            + "1 23\r\n"
            + "1 999\r\n"
            + "5 23\r\n"
            + "5 999\r\n"
            + "23 999\r\n");
    testCorrect(
        "4 2\n"
            + "9 7 9 1",
        "1 7\r\n"
            + "1 9\r\n"
            + "7 9\r\n"
            + "9 9\r\n");
    testCorrect(
        "3 1\n"
            + "4 4 2",
        "2\r\n"
            + "4\r\n");
    testCorrect(
        "4 4\r\n"
            + "1 1 2 2",
        "1 1 2 2\r\n");
  }
}
