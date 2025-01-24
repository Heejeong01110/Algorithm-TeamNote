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

class q16928Test {

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

    q16928.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("1 1\n"
        + "5 88\n"
        + "94 90\n", "4");
    testCorrect("3 7\n"
        + "32 62\n"
        + "42 68\n"
        + "12 98\n"
        + "95 13\n"
        + "97 25\n"
        + "93 37\n"
        + "79 27\n"
        + "75 19\n"
        + "49 47\n"
        + "67 17\n", "3");
    testCorrect("4 9\n"
        + "8 52\n"
        + "6 80\n"
        + "26 42\n"
        + "2 72\n"
        + "51 19\n"
        + "39 11\n"
        + "37 29\n"
        + "81 3\n"
        + "59 5\n"
        + "79 23\n"
        + "53 7\n"
        + "43 33\n"
        + "77 21\n", "5");
  }
}
