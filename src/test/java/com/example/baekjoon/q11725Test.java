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

public class q11725Test {

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

    q11725.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("7\n"
        + "1 6\n"
        + "6 3\n"
        + "3 5\n"
        + "4 1\n"
        + "2 4\n"
        + "4 7", "4\n"
        + "6\n"
        + "1\n"
        + "3\n"
        + "1\n"
        + "4\n");
    testCorrect("12\n"
        + "1 2\n"
        + "1 3\n"
        + "2 4\n"
        + "3 5\n"
        + "3 6\n"
        + "4 7\n"
        + "4 8\n"
        + "5 9\n"
        + "5 10\n"
        + "6 11\n"
        + "6 12", "1\n"
        + "1\n"
        + "2\n"
        + "3\n"
        + "3\n"
        + "4\n"
        + "4\n"
        + "5\n"
        + "5\n"
        + "6\n"
        + "6\n");
  }
}
