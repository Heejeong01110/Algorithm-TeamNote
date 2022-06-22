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

public class q14891Test {

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

    q14891.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("10101111\n"
        + "01111101\n"
        + "11001110\n"
        + "00000010\n"
        + "2\n"
        + "3 -1\n"
        + "1 1", "7");
    testCorrect("11111111\n"
        + "11111111\n"
        + "11111111\n"
        + "11111111\n"
        + "3\n"
        + "1 1\n"
        + "2 1\n"
        + "3 1", "15");
    testCorrect("10001011\n"
        + "10000011\n"
        + "01011011\n"
        + "00111101\n"
        + "5\n"
        + "1 1\n"
        + "2 1\n"
        + "3 1\n"
        + "4 1\n"
        + "1 -1", "6");
    testCorrect("10010011\n"
        + "01010011\n"
        + "11100011\n"
        + "01010101\n"
        + "8\n"
        + "1 1\n"
        + "2 1\n"
        + "3 1\n"
        + "4 1\n"
        + "1 -1\n"
        + "2 -1\n"
        + "3 -1\n"
        + "4 -1", "5");
  }
}
