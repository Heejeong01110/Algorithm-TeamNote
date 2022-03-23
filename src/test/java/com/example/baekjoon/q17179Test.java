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

public class q17179Test {

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

    q17179.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("2 5 70\n"
        + "10\n"
        + "20\n"
        + "35\n"
        + "55\n"
        + "60\n"
        + "3\n"
        + "4", "15\n"
        + "10\n");
  }
}
