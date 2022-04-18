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

public class q12100Test {

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

    q12100.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4\n"
        + "2 2 2 2\n"
        + "2 2 2 2\n"
        + "2 2 2 2\n"
        + "2 2 2 2\n", "32");
    testCorrect("3\n"
        + "4 2 2\n"
        + "4 4 8\n"
        + "8 8 16", "32");
    testCorrect("3\n"
        + "2 2 2\n"
        + "4 4 4\n"
        + "8 8 8", "16");
  }
}
