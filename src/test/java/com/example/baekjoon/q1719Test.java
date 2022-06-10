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

public class q1719Test {

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

    q1719.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6 10\n"
        + "1 2 2\n"
        + "1 3 1\n"
        + "2 4 5\n"
        + "2 5 3\n"
        + "2 6 7\n"
        + "3 4 4\n"
        + "3 5 6\n"
        + "3 6 7\n"
        + "4 6 4\n"
        + "5 6 2", "- 2 3 3 2 2 \n"
        + "1 - 1 4 5 5 \n"
        + "1 1 - 4 5 6 \n"
        + "3 2 3 - 6 6 \n"
        + "2 2 3 6 - 6 \n"
        + "5 5 3 4 5 - \n");
  }
}
