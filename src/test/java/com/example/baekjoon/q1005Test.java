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

public class q1005Test {

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

    q1005.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("2\n"
        + "4 4\n"
        + "10 1 100 10\n"
        + "1 2\n"
        + "1 3\n"
        + "2 4\n"
        + "3 4\n"
        + "4\n"
        + "8 8\n"
        + "10 20 1 5 8 7 1 43\n"
        + "1 2\n"
        + "1 3\n"
        + "2 4\n"
        + "2 5\n"
        + "3 6\n"
        + "5 7\n"
        + "6 7\n"
        + "7 8\n"
        + "7", "120\n"
        + "39\n");
    testCorrect("5\n"
        + "3 2\n"
        + "1 2 3\n"
        + "3 2\n"
        + "2 1\n"
        + "1\n"
        + "4 3\n"
        + "5 5 5 5\n"
        + "1 2\n"
        + "1 3\n"
        + "2 3\n"
        + "4\n"
        + "5 10\n"
        + "100000 99999 99997 99994 99990\n"
        + "4 5\n"
        + "3 5\n"
        + "3 4\n"
        + "2 5\n"
        + "2 4\n"
        + "2 3\n"
        + "1 5\n"
        + "1 4\n"
        + "1 3\n"
        + "1 2\n"
        + "4\n"
        + "4 3\n"
        + "1 1 1 1\n"
        + "1 2\n"
        + "3 2\n"
        + "1 4\n"
        + "4\n"
        + "7 8\n"
        + "0 0 0 0 0 0 0\n"
        + "1 2\n"
        + "1 3\n"
        + "2 4\n"
        + "3 4\n"
        + "4 5\n"
        + "4 6\n"
        + "5 7\n"
        + "6 7\n"
        + "7", "6\n"
        + "5\n"
        + "399990\n"
        + "2\n"
        + "0\n");
  }
}
