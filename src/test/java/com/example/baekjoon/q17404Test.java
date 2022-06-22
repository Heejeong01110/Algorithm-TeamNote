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

public class q17404Test {

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

    q17404.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3\n"
        + "26 40 83\n"
        + "49 60 57\n"
        + "13 89 99", "110");
    testCorrect("3\n"
        + "1 100 100\n"
        + "100 1 100\n"
        + "100 100 1", "3");
    testCorrect("3\n"
        + "1 100 100\n"
        + "100 100 100\n"
        + "1 100 100", "201");
    testCorrect("6\n"
        + "30 19 5\n"
        + "64 77 64\n"
        + "15 19 97\n"
        + "4 71 57\n"
        + "90 86 84\n"
        + "93 32 91", "208");
    testCorrect("8\n"
        + "71 39 44\n"
        + "32 83 55\n"
        + "51 37 63\n"
        + "89 29 100\n"
        + "83 58 11\n"
        + "65 13 15\n"
        + "47 25 29\n"
        + "60 66 19", "253");
  }
}
