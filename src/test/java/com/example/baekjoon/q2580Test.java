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

public class q2580Test {

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

    q2580.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect(
        "0 3 5 4 6 9 2 7 8\n"
            + "7 8 2 1 0 5 6 0 9\n"
            + "0 6 0 2 7 8 1 3 5\n"
            + "3 2 1 0 4 6 8 9 7\n"
            + "8 0 4 9 1 3 5 0 6\n"
            + "5 9 6 8 2 0 4 1 3\n"
            + "9 1 7 6 5 2 0 8 0\n"
            + "6 0 3 7 0 1 9 5 2\n"
            + "2 5 8 3 9 4 7 6 0",
        "1 3 5 4 6 9 2 7 8 \n"
            + "7 8 2 1 3 5 6 4 9 \n"
            + "4 6 9 2 7 8 1 3 5 \n"
            + "3 2 1 5 4 6 8 9 7 \n"
            + "8 7 4 9 1 3 5 2 6 \n"
            + "5 9 6 8 2 7 4 1 3 \n"
            + "9 1 7 6 5 2 3 8 4 \n"
            + "6 4 3 7 8 1 9 5 2 \n"
            + "2 5 8 3 9 4 7 6 1 \n");
  }
}
