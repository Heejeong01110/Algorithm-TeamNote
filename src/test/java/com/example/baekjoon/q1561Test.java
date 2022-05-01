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

public class q1561Test {

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

    q1561.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {

    testCorrect("24 5\n"
        + "1 2 2 4 4", "4");
    testCorrect("3 5\n"
        + "7 8 9 7 8", "3");
    testCorrect("7 2\n"
        + "3 2", "2");


    testCorrect("22 5\n"
        + "1 2 3 4 5", "4");
    testCorrect("1999999999 2\n"
        + "29 30", "2");
    testCorrect("2000000000 1\n"
        + "30", "1");
  }
}
