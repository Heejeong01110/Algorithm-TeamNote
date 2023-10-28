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

class q2159Test {

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

    q2159 q = new q2159();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3\n"
        + "2 2\n"
        + "3 6\n"
        + "6 7\n"
        + "7 3", "11");
    testCorrect("4\n"
        + "3 2\n"
        + "4 4\n"
        + "5 2\n"
        + "4 3\n"
        + "4 4", "4");
    testCorrect("5\n"
        + "50 50\n"
        + "10 10\n"
        + "60 60\n"
        + "10 60\n"
        + "60 10\n"
        + "50 40", "361");
  }
}
