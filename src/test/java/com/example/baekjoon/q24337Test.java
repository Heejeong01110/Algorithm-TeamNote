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

class q24337Test {

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

    q24337 q = new q24337();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {

    testCorrect("9 1 5", "5 1 1 1 1 4 3 2 1");
    testCorrect("10 1 9", "9 1 8 7 6 5 4 3 2 1");
    testCorrect("10 1 10", "10 9 8 7 6 5 4 3 2 1");

    testCorrect("10 5 5", "1 1 2 3 4 5 4 3 2 1");
    testCorrect("5 3 3", "1 2 3 2 1");
    testCorrect("5 2 1", "1 1 1 1 2");
    testCorrect("3 3 1", "1 2 3");
    testCorrect("5 3 2", "1 1 2 3 1");
    testCorrect("10 10 1", "1 2 3 4 5 6 7 8 9 10");
    testCorrect("2 2 1", "1 2");
    testCorrect("10 3 2", "1 1 1 1 1 1 1 2 3 1");
    testCorrect("10 6 3", "1 1 1 2 3 4 5 6 2 1");
    testCorrect("10 3 6", "1 1 1 2 6 5 4 3 2 1");
    testCorrect("10 6 5", "1 2 3 4 5 6 4 3 2 1");
    testCorrect("10 6 6", "-1");
    testCorrect("3 3 1", "1 2 3");
    testCorrect("1 1 1", "1");
  }
}
