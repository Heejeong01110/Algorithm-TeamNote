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

public class q1943Test {

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

    q1943.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect(
        "3\n"
            + "700 2\n"
            + "600 2\n"
            + "400 2\n"
            + "2\n"
            + "500 1\n"
            + "50 1\n"
            + "3\n"
            + "100 2\n"
            + "50 1\n"
            + "10 5\n"
            + "3\n"
            + "1 1\n"
            + "2 1\n"
            + "3 1\n",

        "1\n"
            + "0\n"
            + "1\n"
            + "1\n");
  }
}
