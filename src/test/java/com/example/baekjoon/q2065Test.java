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

class q2065Test {

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

    q2065.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
//    testCorrect("2 10 10\n"
//        + "0 left\n"
//        + "10 left\n"
//        + "20 left\n"
//        + "30 left\n"
//        + "40 left\n"
//        + "50 left\n"
//        + "60 left\n"
//        + "70 left\n"
//        + "80 left\n"
//        + "90 left\n", "10\n"
//        + "30\n"
//        + "30\n"
//        + "50\n"
//        + "50\n"
//        + "70\n"
//        + "70\n"
//        + "90\n"
//        + "90\n"
//        + "110\n");
    testCorrect("2 10 3\n"
        + "10 right\n"
        + "25 left\n"
        + "40 left\n", "30\n"
        + "40\n"
        + "60\n");
    testCorrect("1 10 3\n"
        + "10 right\n"
        + "15 right\n"
        + "20 left\n", "30\n"
        + "50\n"
        + "40\n");
  }
}
