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

public class q15686Test {

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

    q15686.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 3\n"
        + "0 0 1 0 0\n"
        + "0 0 2 0 1\n"
        + "0 1 2 0 0\n"
        + "0 0 1 0 0\n"
        + "0 0 0 0 2", "5");
    testCorrect("5 2\n"
        + "0 2 0 1 0\n"
        + "1 0 1 0 0\n"
        + "0 0 0 0 0\n"
        + "2 0 0 1 1\n"
        + "2 2 0 1 2", "10");
    testCorrect("5 1\n"
        + "1 2 0 0 0\n"
        + "1 2 0 0 0\n"
        + "1 2 0 0 0\n"
        + "1 2 0 0 0\n"
        + "1 2 0 0 0", "11");
    testCorrect("5 1\n"
        + "1 2 0 2 1\n"
        + "1 2 0 2 1\n"
        + "1 2 0 2 1\n"
        + "1 2 0 2 1\n"
        + "1 2 0 2 1", "32");
  }
}
