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

class q24042Test {

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

    q24042 q = new q24042();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4 5\n"
        + "1 2\n"
        + "3 4\n"
        + "1 3\n"
        + "4 1\n"
        + "2 3", "4");
    testCorrect("8 12\n"
        + "3 4\n"
        + "5 6\n"
        + "7 8\n"
        + "2 3\n"
        + "1 5\n"
        + "4 8\n"
        + "1 2\n"
        + "6 7\n"
        + "2 3\n"
        + "7 8\n"
        + "1 2\n"
        + "6 7", "18");
  }
}
