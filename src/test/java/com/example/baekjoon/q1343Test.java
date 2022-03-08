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

public class q1343Test {

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

    q1343.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("....", "....");
    testCorrect("XXXXXX....", "AAAABB....");
    testCorrect("XXXXXX", "AAAABB");
    testCorrect("XXXX....XXX.....XX", "-1");
    testCorrect("XX.XX", "BB.BB");
    testCorrect("X", "-1");
    testCorrect("XX.XXXXXXXXXX..XXXXXXXX...XXXXXX", "BB.AAAAAAAABB..AAAAAAAA...AAAABB");
  }
}
