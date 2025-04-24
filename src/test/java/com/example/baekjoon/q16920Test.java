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

class q16920Test {

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

    q16920 q = new q16920();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 5 2\n"
        + "1 1\n"
        + "1....\n"
        + ".###.\n"
        + ".#.#.\n"
        + ".###.\n"
        + "....2", "9 7 ");
    testCorrect("5 10 4\n"
        + "1 2 1 2\n"
        + "1........2\n"
        + ".....44...\n"
        + "......4...\n"
        + "2.........\n"
        + "....3.....", "5 21 4 20 ");
    testCorrect("4 10 4\n"
        + "1000000000 1 100 99999\n"
        + "1#........\n"
        + "#.........\n"
        + "2#.......#\n"
        + "3#......#4", "1 1 1 1 ");
    testCorrect("4 10 1\n"
        + "1000000000\n"
        + "1.........\n"
        + "1.........\n"
        + "1.........\n"
        + "1.........", "40 ");
    testCorrect("3 9 9\n"
        + "1 1 1 1 1 1 1 1 1\n"
        + "123456789\n"
        + ".#......#\n"
        + "#######..", "2 1 2 2 2 2 2 4 1 ");
    testCorrect("2 5 3\n"
        + "2 2 1\n"
        + "1....\n"
        + "..3.2", "5 4 1 ");
    testCorrect("2 3 1\n"
        + "2\n"
        + "1..\n"
        + "...", "6 ");
    testCorrect("3 3 2\n"
        + "1 1\n"
        + "1..\n"
        + "...\n"
        + "..2", "6 3 ");
    testCorrect("3 3 2\n"
        + "1 1\n"
        + "1.1\n"
        + "...\n"
        + "..2", "7 2 ");
    testCorrect("4 4 2\n"
        + "1 1\n"
        + "1...\n"
        + "....\n"
        + "....\n"
        + "...2", "10 6 ");
    testCorrect("4 4 2\n"
        + "1 1\n"
        + "1..1\n"
        + "....\n"
        + "....\n"
        + "...2", "11 5 ");
    testCorrect("4 4 2\n"
        + "2 1\n"
        + "1..1\n"
        + "....\n"
        + "....\n"
        + "...2", "14 2 ");
    testCorrect("4 4 2\n"
        + "3 1\n"
        + "1..1\n"
        + "....\n"
        + "....\n"
        + "...2", "14 2 ");
    testCorrect("4 4 2\n"
        + "1 1\n"
        + "1..1\n"
        + "#.##\n"
        + "....\n"
        + "...2", "7 6 ");
    testCorrect("4 4 2\n"
        + "2 1\n"
        + "1..1\n"
        + "#.##\n"
        + "....\n"
        + "...2", "10 3 ");
    testCorrect("3 4 4\n"
        + "1 1 1 1\n"
        + "....\n"
        + "#...\n"
        + "1234", "1 4 3 3 ");
    testCorrect("5 7 2\n"
        + "4 1\n"
        + "...1...\n"
        + ".......\n"
        + ".......\n"
        + ".......\n"
        + "1....2..", "32 3 ");
    testCorrect("5 10 4\n"
        + "1 2 1 2\n"
        + "1........2\n"
        + ".....44...\n"
        + "......4...\n"
        + "2.........\n"
        + "....3.....", "5 21 4 20 ");
    testCorrect("3 4 2\n"
        + "2 1\n"
        + "1...\n"
        + "1..2\n"
        + "....", "9 3 ");
    testCorrect("3 4 4\n"
        + "1 1 1 1\n"
        + ".#..\n"
        + "#..#\n"
        + "1234", "1 2 4 1 ");
  }
}
