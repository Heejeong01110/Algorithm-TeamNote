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

public class q20551Test {

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

    q20551.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 5\n"
        + "9\n"
        + "0\n"
        + "-1\n"
        + "3\n"
        + "2\n"
        + "-1\n"
        + "10\n"
        + "5\n"
        + "9\n"
        + "0", "0\n"
        + "-1\n"
        + "-1\n"
        + "4\n"
        + "1\n");
    testCorrect("8 4\n"
        + "3\n"
        + "3\n"
        + "4\n"
        + "9\n"
        + "2\n"
        + "5\n"
        + "3\n"
        + "4\n"
        + "3\n"
        + "10\n"
        + "4\n"
        + "2", "1\n"
        + "-1\n"
        + "4\n"
        + "0\n");
  }
}
