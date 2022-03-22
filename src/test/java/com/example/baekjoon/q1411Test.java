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

public class q1411Test {

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

    q1411.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5\n"
        + "aa\n"
        + "ab\n"
        + "bb\n"
        + "cc\n"
        + "cd", "4");
    testCorrect("3\n"
        + "abca\n"
        + "zbxz\n"
        + "opqr", "1");
    testCorrect("12\n"
        + "cacccdaabc\n"
        + "cdcccaddbc\n"
        + "dcdddbccad\n"
        + "bdbbbaddcb\n"
        + "bdbcadbbdc\n"
        + "abaadcbbda\n"
        + "babcdabbac\n"
        + "cacdbaccad\n"
        + "dcddabccad\n"
        + "cacccbaadb\n"
        + "bbcdcbcbdd\n"
        + "bcbadcbbca", "13");
  }
}
