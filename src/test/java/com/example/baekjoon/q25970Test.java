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

class q25970Test {

  private static OutputStream out;
  private static InputStream in;

  @BeforeAll
  static void setting() {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
  }

  private void testCorrect(String input, String output) throws IOException {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    q25970.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("1\n"
        + "111\n"
        + "101\n"
        + "1\n"
        + "11110100101001101\n", "LOW 1\n");
    testCorrect("4\n"
        + "00000\n"
        + "10110\n"
        + "00110\n"
        + "1010\n"
        + "000\n"
        + "111\n"
        + "0010\n"
        + "10010\n"
        + "5\n"
        + "001000111110011000\n"
        + "1100111010001101\n"
        + "11001101001100000000\n"
        + "1110010010\n"
        + "1000001110010\n", "LOW 5\n"
        + "GOOD\n"
        + "HIGH 1\n"
        + "LOW 5\n"
        + "LOW 5\n");
  }
}
