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

public class q16933Test {

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

    q16933.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("1 4 1\n"
        + "0010", "5");
    testCorrect("1 4 1\n"
        + "0100", "4");
    testCorrect("6 4 1\n"
        + "0100\n"
        + "1110\n"
        + "1000\n"
        + "0000\n"
        + "0111\n"
        + "0000", "15");
    testCorrect("6 4 2\n"
        + "0100\n"
        + "1110\n"
        + "1000\n"
        + "0000\n"
        + "0111\n"
        + "0000", "9");
  }
}
