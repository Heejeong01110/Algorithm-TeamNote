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

public class q2458Test {

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

    q2458.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6 6\n"
        + "1 5\n"
        + "3 4\n"
        + "5 4\n"
        + "4 2\n"
        + "4 6\n"
        + "5 2", "1");
    testCorrect("6 7\n"
        + "1 3\n"
        + "1 5\n"
        + "3 4\n"
        + "5 4\n"
        + "4 2\n"
        + "4 6\n"
        + "5 2", "2");
    testCorrect("6 3\n"
        + "1 2\n"
        + "2 3\n"
        + "4 5", "0");

  }
}
