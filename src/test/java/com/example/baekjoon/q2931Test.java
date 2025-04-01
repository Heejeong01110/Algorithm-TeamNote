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

class q2931Test {

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

    q2931.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
//    testCorrect("3 2\n"
//        + "MZ\n"
//        + "||\n"
//        + ".3\n", "3 1 2");
    testCorrect("3 7\n"
        + ".14....\n"
        + ".M.Z...\n"
        + "..23...\n", "2 3 |");
    testCorrect("3 7\n"
        + ".......\n"
        + ".M-.-Z.\n"
        + ".......\n", "2 4 -");
    testCorrect("3 5\n"
        + "..1-M\n"
        + "1-+..\n"
        + "Z.23.\n", "2 4 4");
    testCorrect("6 10\n"
        + "Z.1----4..\n"
        + "|.|....|..\n"
        + "|..14..M..\n"
        + "2-+++4....\n"
        + "..2323....\n"
        + "..........\n", "3 3 |");
  }
}
