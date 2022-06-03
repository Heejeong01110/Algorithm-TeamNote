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

public class q1014Test {

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

    q1014.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4\n"
        + "2 3\n"
        + "...\n"
        + "...\n"
        + "2 3\n"
        + "x.x\n"
        + "xxx\n"
        + "2 3\n"
        + "x.x\n"
        + "x.x\n"
        + "10 10\n"
        + "....x.....\n"
        + "..........\n"
        + "..........\n"
        + "..x.......\n"
        + "..........\n"
        + "x...x.x...\n"
        + ".........x\n"
        + "...x......\n"
        + "........x.\n"
        + ".x...x....", "4\n"
        + "1\n"
        + "2\n"
        + "46");
  }
}
