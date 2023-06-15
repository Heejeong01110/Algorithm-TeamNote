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

class q1029Test {

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

    q1029 q = new q1029();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5\n"
        + "15555\n"
        + "11111\n"
        + "15111\n"
        + "11111\n"
        + "11111", "3");
    testCorrect("10\n"
        + "0100000000\n"
        + "0020000000\n"
        + "0003000000\n"
        + "0000400000\n"
        + "0000050000\n"
        + "0000006000\n"
        + "0000000700\n"
        + "0000000080\n"
        + "0000000009\n"
        + "1111111111", "10");

    testCorrect("3\n"
        + "022\n"
        + "101\n"
        + "110", "2");
    testCorrect("2\n"
        + "01\n"
        + "10", "2");
    testCorrect("5\n"
        + "01231\n"
        + "00231\n"
        + "00031\n"
        + "00002\n"
        + "00000", "4");
  }
}
