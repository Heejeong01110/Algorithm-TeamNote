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

class q1700Test {

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

    q1700.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("2 9\n"
        + "1 2 3 1 2 3 1 2 3", "4");
    testCorrect("3 100\n"
        + "56 71 70 25 52 77 76 8 68 71 51 65 13 23 7 16 19 54 95 18 86 74 29 76 61 93 44 96 32 72 64 19 50 49 22 14 7 64 24 83 6 3 2 76 99 7 76 100 60 60 6 50 90 49 27 51 37 61 16 84 89 51 73 28 90 77 73 39 78 96 78 13 92 54 70 69 62 78 7 75 30 67 97 98 19 86 90 90 2 39 41 58 57 84 19 8 52 39 26 7", "80");
    testCorrect("3 14\n"
        + "1 4 3 2 5 4 3 2 5 3 4 2 3 4", "4");
    testCorrect("3 13\n"
        + "2 3 4 2 3 4 1 5 5 5 2 3 2", "2");
    testCorrect("2 10\n"
        + "1 1 2 1 1 2 1 1 2 1", "0");
    testCorrect("4 20\n"
        + "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5", "4");
    testCorrect("3 5\n"
        + "1 1 1 1 2", "0");
    testCorrect("2 11\n"
        + "1 2 3 4 5 1 1 1 2 2 2", "4");
    testCorrect("3 9\n"
        + "1 2 3 4 1 1 1 1 3", "1");
    testCorrect("3 11\n"
        + "11 8 11 7 2 8 2 7 5 10 2", "3");
    testCorrect("2 5\n"
        + "5 2 2 3 5", "1");
    testCorrect("2 4\n"
        + "5 3 1 5", "1");
    testCorrect("2 15\n"
        + "3 2 1 2 1 2 1 2 1 3 3 3 3 3 3", "2");
  }
}
