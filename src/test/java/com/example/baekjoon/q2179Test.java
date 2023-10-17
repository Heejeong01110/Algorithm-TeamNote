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

class q2179Test {

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

    q2179 q = new q2179();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("9\n"
        + "noon\n"
        + "is\n"
        + "lunch\n"
        + "for\n"
        + "most\n"
        + "noone\n"
        + "waits\n"
        + "until\n"
        + "two", "noon\n"
        + "noone");
    testCorrect("4\n"
        + "abcd\n"
        + "abe\n"
        + "abc\n"
        + "abchldp", "abcd\n"
        + "abc");
  }
}
