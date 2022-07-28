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

public class q1043Test {

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

    q1043.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4 1\n"
        + "1 1\n"
        + "4 1 2 3 4", "0");
    testCorrect("4 1\n"
        + "0\n"
        + "4 1 2 3 4", "1");
    testCorrect("4 5\n"
        + "1 1\n"
        + "1 1\n"
        + "1 2\n"
        + "1 3\n"
        + "1 4\n"
        + "2 4 1", "2");
    testCorrect("10 9\n"
        + "4 1 2 3 4\n"
        + "2 1 5\n"
        + "2 2 6\n"
        + "1 7\n"
        + "1 8\n"
        + "2 7 8\n"
        + "1 9\n"
        + "1 10\n"
        + "2 3 10\n"
        + "1 4", "4");
    testCorrect("8 5\n"
        + "3 1 2 7\n"
        + "2 3 4\n"
        + "1 5\n"
        + "2 5 6\n"
        + "2 6 8\n"
        + "1 8", "5");
    testCorrect("3 4\n"
        + "1 3\n"
        + "1 1\n"
        + "1 2\n"
        + "2 1 2\n"
        + "3 1 2 3", "0");
    testCorrect("4 3\n"
        + "0\n"
        + "2 1 2\n"
        + "1 3\n"
        + "3 2 3 4", "3");
  }
}
