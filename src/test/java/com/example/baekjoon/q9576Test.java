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

public class q9576Test {

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

    q9576.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("1\n"
        + "7 4\n"
        + "1 7\n"
        + "1 7\n"
        + "1 7\n"
        + "2 2", "4\n");
    testCorrect("1\n"
        + "5 5\n"
        + "2 5\n"
        + "2 5\n"
        + "2 5\n"
        + "1 2\n"
        + "1 1", "5\n");
    testCorrect("1\n"
        + "2 3\n"
        + "1 2\n"
        + "1 2\n"
        + "1 2", "2\n");
  }
}
