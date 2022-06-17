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

public class q16434Test {

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

    q16434.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("8 3\n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "2 3 70\n"
        + "1 3 100", "61");
    testCorrect("3 3\n"
        + "1 1 49\n"
        + "2 3 1\n"
        + "1 3 100", "64");
    testCorrect("5 3 \n"
        + "1 1 31\n"
        + "2 1 31\n"
        + "1 1 1\n"
        + "2 3 70\n"
        + "1 3 48", "19");
    testCorrect("5 8\n"
        + "1 1 20\n"
        + "1 3 10\n"
        + "1 3 100\n"
        + "2 5 20\n"
        + "1 3 10", "42");
    testCorrect("8 3 \n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "1 1 31\n"
        + "2 3 70\n"
        + "1 3 100", "61");
    testCorrect("3 3\n"
        + "1 1 20\n"
        + "2 3 10\n"
        + "1 3 100", "49");
    testCorrect("1 1\n"
        + "1 1000000 1000000", "999999000001");
  }
}
