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

class q15653Test {

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

    q15653.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5 5\n"
        + "#####\n"
        + "#..B#\n"
        + "#.#.#\n"
        + "#RO.#\n"
        + "#####\n", "1");
    testCorrect("7 7\n"
        + "#######\n"
        + "#...RB#\n"
        + "#.#####\n"
        + "#.....#\n"
        + "#####.#\n"
        + "#O....#\n"
        + "#######\n", "5");
    testCorrect("7 7\n"
        + "#######\n"
        + "#..R#B#\n"
        + "#.#####\n"
        + "#.....#\n"
        + "#####.#\n"
        + "#O....#\n"
        + "#######\n", "5");
    testCorrect("10 10\n"
        + "##########\n"
        + "#R#...##B#\n"
        + "#...#.##.#\n"
        + "#####.##.#\n"
        + "#......#.#\n"
        + "#.######.#\n"
        + "#.#...##.#\n"
        + "#.#.#.#..#\n"
        + "#...#.O#.#\n"
        + "##########\n", "12");
    testCorrect("3 7\n"
        + "#######\n"
        + "#R.O.B#\n"
        + "#######\n", "1");
    testCorrect("10 10\n"
        + "##########\n"
        + "#R#...##B#\n"
        + "#...#.##.#\n"
        + "#####.##.#\n"
        + "#......#.#\n"
        + "#.######.#\n"
        + "#.#....#.#\n"
        + "#.#.##...#\n"
        + "#O..#....#\n"
        + "##########\n", "7");
    testCorrect("3 10\n"
        + "##########\n"
        + "#.O....RB#\n"
        + "##########\n", "-1");
  }
}
