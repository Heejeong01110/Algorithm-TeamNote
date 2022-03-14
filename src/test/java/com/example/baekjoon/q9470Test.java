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

public class q9470Test {

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

    q9470.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("1\n"
        + "1 7 8\n"
        + "1 3\n"
        + "2 3\n"
        + "6 4\n"
        + "3 4\n"
        + "3 5\n"
        + "6 7\n"
        + "5 7\n"
        + "4 7", "1 3\n");

    testCorrect("1\n"
        + "1 5 4\n"
        + "1 2\n"
        + "2 3\n"
        + "3 4\n"
        + "4 5", "1 1\n");


    testCorrect("4\n"
        + "173 4 3\n"
        + "3 4\n"
        + "2 4\n"
        + "1 4\n"
        + "174 6 9\n"
        + "5 6\n"
        + "4 6\n"
        + "3 6\n"
        + "2 5\n"
        + "2 4\n"
        + "2 3\n"
        + "1 5\n"
        + "1 4\n"
        + "1 3\n"
        + "175 8 13\n"
        + "7 8\n"
        + "6 8\n"
        + "5 8\n"
        + "4 7\n"
        + "4 6\n"
        + "4 5\n"
        + "3 7\n"
        + "3 6\n"
        + "3 5\n"
        + "2 4\n"
        + "2 3\n"
        + "1 4\n"
        + "1 3\n"
        + "168 10 17\n"
        + "9 10\n"
        + "8 10\n"
        + "7 10\n"
        + "6 9\n"
        + "6 8\n"
        + "6 7\n"
        + "5 9\n"
        + "5 8\n"
        + "5 7\n"
        + "4 6\n"
        + "4 5\n"
        + "3 6\n"
        + "3 5\n"
        + "2 4\n"
        + "2 3\n"
        + "1 4\n"
        + "1 3", "173 2\n"
        + "174 3\n"
        + "175 4\n"
        + "168 5\n");
  }
}
