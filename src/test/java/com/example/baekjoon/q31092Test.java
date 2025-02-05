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

class q31092Test {

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

    q31092.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 5 3\n"
        + "w 3 1\n"
        + "a 2 2\n"
        + "p 1 3\n"
        + "a 2 2\n"
        + "s 3 1\n"
        + "1 2 3 4 5\n"
        + "aaa\n", "3");
    testCorrect("3 6 3\n"
        + "b 1 2\n"
        + "o 2 3\n"
        + "j 3 4\n"
        + "b 4 5\n"
        + "o 5 6\n"
        + "j 6 7\n"
        + "1 5 3\n"
        + "boj\n", "0");
    testCorrect("3 4 3\n"
        + "g 1 1\n"
        + "o 2 2\n"
        + "o 3 3\n"
        + "d 4 4\n"
        + "3 2 1\n"
        + "bye\n", "-1");
  }
}
