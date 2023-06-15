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

class q1826Test {

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

    q1826 q = new q1826();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4\n"
        + "4 4\n"
        + "5 2\n"
        + "11 5\n"
        + "15 10\n"
        + "25 10", "3");
  }
}
