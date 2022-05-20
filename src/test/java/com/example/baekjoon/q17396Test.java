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

public class q17396Test {

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

    q17396.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 7\n"
        + "0 0 0 1 1\n"
        + "0 1 7\n"
        + "0 2 2\n"
        + "1 2 4\n"
        + "1 3 3\n"
        + "1 4 6\n"
        + "2 3 2\n"
        + "3 4 1", "12");
    testCorrect("5 7\n"
        + "0 1 0 1 1\n"
        + "0 1 7\n"
        + "0 2 2\n"
        + "1 2 4\n"
        + "1 3 3\n"
        + "1 4 6\n"
        + "2 3 2\n"
        + "3 4 1", "-1");
  }
}
