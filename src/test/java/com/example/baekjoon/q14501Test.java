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

class q14501Test {

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

    q14501 q = new q14501();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("10\n"
        + "5 50\n"
        + "4 40\n"
        + "3 30\n"
        + "2 20\n"
        + "1 10\n"
        + "1 10\n"
        + "2 20\n"
        + "3 30\n"
        + "4 40\n"
        + "5 50", "90");
    testCorrect("7\n"
        + "3 10\n"
        + "5 20\n"
        + "1 10\n"
        + "1 20\n"
        + "2 15\n"
        + "4 40\n"
        + "2 200", "45");
    testCorrect("10\n"
        + "1 1\n"
        + "1 2\n"
        + "1 3\n"
        + "1 4\n"
        + "1 5\n"
        + "1 6\n"
        + "1 7\n"
        + "1 8\n"
        + "1 9\n"
        + "1 10", "55");
    testCorrect("10\n"
        + "5 10\n"
        + "5 9\n"
        + "5 8\n"
        + "5 7\n"
        + "5 6\n"
        + "5 10\n"
        + "5 9\n"
        + "5 8\n"
        + "5 7\n"
        + "5 6", "20");
  }
}
