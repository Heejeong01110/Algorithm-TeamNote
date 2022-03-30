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

public class q5549Test {

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

    q5549.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4 7\n"
        + "4\n"
        + "JIOJOIJ\n"
        + "IOJOIJO\n"
        + "JOIJOOI\n"
        + "OOJJIJO\n"
        + "3 5 4 7\n"
        + "2 2 3 6\n"
        + "2 2 2 2\n"
        + "1 1 4 7", "1 3 2\n"
        + "3 5 2\n"
        + "0 1 0\n"
        + "10 11 7\n");
  }
}
