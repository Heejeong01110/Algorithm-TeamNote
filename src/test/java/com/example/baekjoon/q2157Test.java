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

class q2157Test {

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

    q2157 q = new q2157();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3 3 5\n"
        + "1 3 10\n"
        + "1 2 5\n"
        + "2 3 3\n"
        + "1 3 4\n"
        + "3 1 100", "10");
    testCorrect("3 3 2\n"
        + "1 2 3\n"
        + "1 3 1", "1");
    testCorrect("3 2 5\n"
        + "1 3 2\n"
        + "1 2 5\n"
        + "2 3 3\n"
        + "1 3 4\n"
        + "3 1 100", "4");
    testCorrect("4 2 6\n"
        + "1 4 2\n"
        + "2 4 3\n"
        + "3 4 1\n"
        + "3 2 5\n"
        + "2 3 4\n"
        + "3 4 2", "2");
  }
}
