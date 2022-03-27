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

public class q12764Test {

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

    q12764.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6\n"
        + "0 15\n"
        + "10 25\n"
        + "20 30\n"
        + "50 70\n"
        + "60 80\n"
        + "100 120", "2\n"
        + "4 2 ");
    testCorrect("6\n"
        + "20 50\n"
        + "10 100\n"
        + "30 120\n"
        + "60 110\n"
        + "80 90\n"
        + "120 130", "4\n"
        + "2 2 1 1 ");
  }
}
