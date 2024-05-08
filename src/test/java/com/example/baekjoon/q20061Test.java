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

class q20061Test {

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

    q20061.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("1\n"
        + "1 1 1", "0\n"
        + "2");
    testCorrect("2\n"
        + "1 1 1\n"
        + "2 3 0", "0\n"
        + "6");
    testCorrect("4\n"
        + "1 1 1\n"
        + "2 3 0\n"
        + "3 2 2\n"
        + "3 2 3", "1\n"
        + "10");
    testCorrect("5\n"
        + "1 1 1\n"
        + "2 3 0\n"
        + "3 2 2\n"
        + "3 2 3\n"
        + "3 1 3", "1\n"
        + "12");
    testCorrect("6\n"
        + "1 1 1\n"
        + "2 3 0\n"
        + "3 2 2\n"
        + "3 2 3\n"
        + "3 1 3\n"
        + "2 0 0", "1\n"
        + "16");
    testCorrect("7\n"
        + "1 1 1\n"
        + "2 3 0\n"
        + "3 2 2\n"
        + "3 2 3\n"
        + "3 1 3\n"
        + "2 0 0\n"
        + "3 2 0", "1\n"
        + "18");
    testCorrect("8\n"
        + "1 1 1\n"
        + "2 3 0\n"
        + "3 2 2\n"
        + "3 2 3\n"
        + "3 1 3\n"
        + "2 0 0\n"
        + "3 2 0\n"
        + "3 1 2", "2\n"
        + "15");
  }
}
