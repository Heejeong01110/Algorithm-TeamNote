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

public class q11724Test {

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

    q11724.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6 5\n"
        + "1 2\n"
        + "2 5\n"
        + "5 1\n"
        + "3 4\n"
        + "4 6", "2");
    testCorrect("6 8\n"
        + "1 2\n"
        + "2 5\n"
        + "5 1\n"
        + "3 4\n"
        + "4 6\n"
        + "5 4\n"
        + "2 4\n"
        + "2 3", "1");
  }
}
