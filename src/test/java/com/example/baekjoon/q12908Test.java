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

public class q12908Test {

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

    q12908.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3 7\n"
        + "10000 30000\n"
        + "3 10 5200 4900\n"
        + "12212 8699 9999 30011\n"
        + "12200 8701 5203 4845", "117");
    testCorrect("3 3\n"
        + "4 5\n"
        + "1000 1001 1000 1002\n"
        + "1000 1003 1000 1004\n"
        + "1000 1005 1000 1006", "3");
    testCorrect("0 0\n"
        + "20 20\n"
        + "1 1 18 20\n"
        + "1000 1003 1000 1004\n"
        + "1000 1005 1000 1006", "14");
    testCorrect("0 0\n"
        + "20 20\n"
        + "1000 1003 1000 1004\n"
        + "18 20 1 1\n"
        + "1000 1005 1000 1006", "14");
    testCorrect("10 10\n"
        + "10000 20000\n"
        + "1000 1003 1000 1004\n"
        + "3 3 10004 20002\n"
        + "1000 1005 1000 1006", "30");

  }
}
