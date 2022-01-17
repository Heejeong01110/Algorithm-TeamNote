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

class q13022Test {
  private static OutputStream out;
  private static InputStream in;

  private void testCorrect(String input, String output) throws IOException {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    q13022.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("wwwooolllfff", "1");
    testCorrect("wolf", "1");
    testCorrect("wwoollff", "1");
    testCorrect("wolfwwoollff", "1");
    testCorrect("wolfwwoollffwolf", "1");
    testCorrect("wfol", "0");
    testCorrect("wwolfolf", "0");
    testCorrect("wwwoolllfff", "0");
  }
}
