package com.example.baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class q3109Test {

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

    q3109 q = new q3109();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {

    testCorrect("5 5\n"
        + ".xx..\n"
        + "..x..\n"
        + ".....\n"
        + "..xx.\n"
        + "...x.", "1");
    testCorrect("5 5\n"
        + ".xx..\n"
        + "..x..\n"
        + ".....\n"
        + "...x.\n"
        + "...x.", "2");
    testCorrect("6 10\n"
        + "..x.......\n"
        + ".....x....\n"
        + ".x....x...\n"
        + "...x...xx.\n"
        + "..........\n"
        + "....x.....", "5");
  }
}
