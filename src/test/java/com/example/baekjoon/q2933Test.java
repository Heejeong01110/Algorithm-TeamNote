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

class q2933Test {

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

    q2933 q = new q2933();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4 6\n"
        + "xxxxxx\n"
        + "xx...x\n"
        + "xx....\n"
        + "xx....\n"
        + "2\n"
        + "4 4", ".xxxx.\n"
        + "xx....\n"
        + "xx....\n"
        + "xx...x\n");
    testCorrect("5 6\n"
        + "......\n"
        + "..xx..\n"
        + "..x...\n"
        + "..xx..\n"
        + ".xxxx.\n"
        + "1\n"
        + "3", "......\n"
        + "......\n"
        + "..xx..\n"
        + "..xx..\n"
        + ".xxxx.\n");
    testCorrect("8 8\n"
        + "........\n"
        + "........\n"
        + "...x.xx.\n"
        + "...xxx..\n"
        + "..xxx...\n"
        + "..x.xxx.\n"
        + "..x...x.\n"
        + ".xxx..x.\n"
        + "5\n"
        + "6 6 4 3 1", "........\n"
        + "........\n"
        + "........\n"
        + "........\n"
        + ".....x..\n"
        + "..xxxx..\n"
        + "..xxx.x.\n"
        + "..xxxxx.\n");
    testCorrect("7 6\n"
        + "......\n"
        + "......\n"
        + "xx....\n"
        + ".xx...\n"
        + "..xx..\n"
        + "...xx.\n"
        + "....x.\n"
        + "2\n"
        + "6 4", "......\n"
        + "......\n"
        + "......\n"
        + "......\n"
        + "..xx..\n"
        + "xx.xx.\n"
        + ".x..x.\n");
    testCorrect("3 8\n"
        + "...xxxxx\n"
        + "...xx...\n"
        + "...xx...\n"
        + "4\n"
        + "1 1 1 1", "........\n"
        + "........\n"
        + "...xxxxx\n");
    testCorrect("7 5\n"
        + ".....\n"
        + ".xxx.\n"
        + ".x...\n"
        + "xx.xx\n"
        + "x...x\n"
        + "x...x\n"
        + "x...x\n"
        + "1\n"
        + "4", ".....\n"
        + ".....\n"
        + ".xxx.\n"
        + ".x.xx\n"
        + "xx..x\n"
        + "x...x\n"
        + "x...x\n");
    testCorrect("9 8\n"
        + "........\n"
        + ".xxxx...\n"
        + ".x......\n"
        + ".x.xxxx.\n"
        + ".x....x.\n"
        + ".x....x.\n"
        + ".xxxx.x.\n"
        + "....xxx.\n"
        + "......x.\n"
        + "1\n"
        + "2\n", "........\n"
        + "........\n"
        + ".xxxx...\n"
        + ".x.xxxx.\n"
        + ".x....x.\n"
        + ".x....x.\n"
        + ".x....x.\n"
        + ".xxxxxx.\n"
        + "......x.\n");
  }
}
