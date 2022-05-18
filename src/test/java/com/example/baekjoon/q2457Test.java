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

public class q2457Test {

  private static OutputStream out;
  private static InputStream in;

  @BeforeAll
  static void setting(){
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
  }

  private void testCorrect(String input, String output) throws IOException {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    q2457.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4\n"
        + "1 1 5 31\n"
        + "1 1 6 30\n"
        + "5 15 8 31\n"
        + "6 10 12 10", "2");
    testCorrect("10\n"
        + "2 15 3 23\n"
        + "4 12 6 5\n"
        + "5 2 5 31\n"
        + "9 14 12 24\n"
        + "6 15 9 3\n"
        + "6 3 6 15\n"
        + "2 28 4 25\n"
        + "6 15 9 27\n"
        + "10 5 12 31\n"
        + "7 14 9 1", "5");
  }
}
