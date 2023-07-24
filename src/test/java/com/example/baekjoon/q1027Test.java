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

class q1027Test {

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

    q1027 q = new q1027();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("15\n"
        + "1 5 3 2 6 3 2 6 4 2 5 7 3 1 5", "7");
    testCorrect("1\n"
        + "10", "0");
    testCorrect("4\n"
        + "5 5 5 5", "2");
    testCorrect("5\n"
        + "1 2 7 3 2", "4");
    testCorrect("10\n"
        + "1000000000 999999999 999999998 999999997 999999996 1 2 3 4 5", "6");
  }
}
