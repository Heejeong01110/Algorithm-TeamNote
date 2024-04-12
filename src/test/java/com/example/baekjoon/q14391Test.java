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

class q14391Test {

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

    q14391 q = new q14391();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("2 3\n"
        + "123\n"
        + "312", "435");
    testCorrect("2 2\n"
        + "99\n"
        + "11", "182");
    testCorrect("4 3\n"
        + "001\n"
        + "010\n"
        + "111\n"
        + "100", "1131");
    testCorrect("1 1\n"
        + "8", "8");
    testCorrect("4 4\n"
        + "1000\n"
        + "0001\n"
        + "0000\n"
        + "1000\n", "2010");
  }
}
