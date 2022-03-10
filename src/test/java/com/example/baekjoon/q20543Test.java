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

public class q20543Test {

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

    q20543.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("""
        5 3
        -2 -2 -4 -2 -2
        -2 -2 -4 -2 -2
        -2 -2 -4 -2 -2
        0 0 0 0 0
        0 0 0 0 0""", "0 0 0 0 0 \n"
        + "0 2 0 2 0 \n"
        + "0 0 0 0 0 \n"
        + "0 0 0 0 0 \n"
        + "0 0 0 0 0 \n");
    testCorrect("""
        5 3
        -8 -17 -26 -18 -9
        -9 -29 -47 -38 -18
        -10 -38 -62 -52 -24
        -2 -21 -36 -34 -15
        -1 -9 -15 -14 -6""", "0 0 0 0 0 \n"
        + "0 8 9 9 0 \n"
        + "0 1 11 9 0 \n"
        + "0 1 8 6 0 \n"
        + "0 0 0 0 0 \n");
    testCorrect("""
        10 3
        -8 -17 -26 -19 -21 -21 -21 -18 -9 -8
        -14 -36 -56 -43 -40 -39 -42 -36 -17 -13
        -20 -50 -70 -53 -46 -54 -60 -59 -31 -22
        -22 -48 -70 -55 -48 -48 -53 -48 -26 -14
        -18 -33 -52 -50 -60 -66 -68 -64 -39 -21
        -17 -31 -63 -62 -69 -53 -51 -45 -29 -15
        -13 -31 -59 -71 -75 -66 -53 -54 -35 -23
        -12 -37 -60 -65 -53 -49 -38 -43 -24 -18
        -7 -25 -35 -43 -38 -47 -37 -39 -20 -15
        -1 -10 -13 -13 -9 -19 -21 -23 -10 -7""", "0 0 0 0 0 0 0 0 0 0 \n"
        + "0 8 9 9 1 11 9 1 8 0 \n"
        + "0 6 13 11 0 8 10 3 5 0 \n"
        + "0 6 8 0 2 4 9 5 9 0 \n"
        + "0 10 5 11 5 7 3 4 0 0 \n"
        + "0 2 2 8 9 14 13 9 12 0 \n"
        + "0 5 7 13 2 0 0 1 3 0 \n"
        + "0 6 9 7 14 8 6 2 8 0 \n"
        + "0 1 9 3 1 5 13 3 7 0 \n"
        + "0 0 0 0 0 0 0 0 0 0 \n");
  }
}
