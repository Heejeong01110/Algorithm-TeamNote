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

class q15684Test {

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

    q15684.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("2 1 3\n"
        + "1 1", "1");
    testCorrect("5 5 6\n"
        + "1 1\n"
        + "3 2\n"
        + "2 3\n"
        + "5 1\n"
        + "5 4", "3");
    testCorrect("6 5 6\n"
        + "1 1\n"
        + "3 2\n"
        + "1 3\n"
        + "2 5\n"
        + "5 5", "3");
    testCorrect("5 8 6\n"
        + "1 1\n"
        + "2 2\n"
        + "3 3\n"
        + "4 4\n"
        + "3 1\n"
        + "4 2\n"
        + "5 3\n"
        + "6 4", "-1");
    testCorrect("5 12 6\n"
        + "1 1\n"
        + "1 3\n"
        + "2 2\n"
        + "2 4\n"
        + "3 1\n"
        + "3 3\n"
        + "4 2\n"
        + "4 4\n"
        + "5 1\n"
        + "5 3\n"
        + "6 2\n"
        + "6 4", "-1");
    testCorrect("5 6 6\n"
        + "1 1\n"
        + "3 1\n"
        + "5 2\n"
        + "4 3\n"
        + "2 3\n"
        + "1 4", "2");
    testCorrect("2 0 3", "0");
  }
}
