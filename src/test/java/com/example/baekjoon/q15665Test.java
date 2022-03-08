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

public class q15665Test {

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

    q15665.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3 1\n"
        + "4 4 2", "2 \n"
        + "4 \n");
    testCorrect("4 2\n"
            + "9 7 9 1",
        "1 1 \n"
            + "1 7 \n"
            + "1 9 \n"
            + "7 1 \n"
            + "7 7 \n"
            + "7 9 \n"
            + "9 1 \n"
            + "9 7 \n"
            + "9 9 \n");

    testCorrect("4 4\n"
            + "1 1 2 2",
        "1 1 1 1 \n"
            + "1 1 1 2 \n"
            + "1 1 2 1 \n"
            + "1 1 2 2 \n"
            + "1 2 1 1 \n"
            + "1 2 1 2 \n"
            + "1 2 2 1 \n"
            + "1 2 2 2 \n"
            + "2 1 1 1 \n"
            + "2 1 1 2 \n"
            + "2 1 2 1 \n"
            + "2 1 2 2 \n"
            + "2 2 1 1 \n"
            + "2 2 1 2 \n"
            + "2 2 2 1 \n"
            + "2 2 2 2 \n");
  }
}
