package com.example.baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class q1049Test {

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

    q1049.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4 2\n"
        + "12 3\n"
        + "15 4", "12");
    testCorrect("10 3\n"
        + "20 8\n"
        + "40 7\n"
        + "60 4", "36");
    testCorrect("15 1\n"
        + "100 40", "300");

    testCorrect("17 1\n"
        + "12 3", "36");
    testCorrect("7 2\n"
        + "10 3\n"
        + "12 2", "12");
    testCorrect("9 16\n"
        + "21 25\n"
        + "77 23\n"
        + "23 88\n"
        + "95 43\n"
        + "96 19\n"
        + "59 36\n"
        + "80 13\n"
        + "51 24\n"
        + "15 8\n"
        + "25 61\n"
        + "21 22\n"
        + "3 9\n"
        + "68 68\n"
        + "67 100\n"
        + "83 98\n"
        + "96 57", "6");
  }
}
