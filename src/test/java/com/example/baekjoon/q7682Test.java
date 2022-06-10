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

public class q7682Test {

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

    q7682.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("XXXOO.XXX\n"
        + "XOXOXOXOX\n"
        + "OXOXOXOXO\n"
        + "XXOOOXXOX\n"
        + "XO.OX...X\n"
        + ".XXX.XOOO\n"
        + "X.OO..X..\n"
        + "OOXXXOOXO\n"
        + "end", "invalid\n"
        + "valid\n"
        + "invalid\n"
        + "valid\n"
        + "valid\n"
        + "invalid\n"
        + "invalid\n"
        + "invalid\n");
  }
}
