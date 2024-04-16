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

class q20926Test {

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

    q20926 q = new q20926();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 5\n"
        + "2E115\n"
        + "32411\n"
        + "11313\n"
        + "R42TH\n"
        + "124R6", "9");
    testCorrect("4 5\n"
        + "11R1\n"
        + "1E1R\n"
        + "1911\n"
        + "1911\n"
        + "1T1R", "4");
    testCorrect("3 3\n"
        + "111\n"
        + "TRE\n"
        + "111", "-1");
    testCorrect("5 5\n"
        + "TRRRR\n"
        + "1R11R\n"
        + "1RE1R\n"
        + "1111R\n"
        + "RRRRR", "9");
  }
}
