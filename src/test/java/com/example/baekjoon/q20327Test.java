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

class q20327Test {

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

    q20327.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3 8\n"
        + "1 2 3 4 5 6 7 8\n"
        + "9 10 11 12 13 14 15 16\n"
        + "17 18 19 20 21 22 23 24\n"
        + "25 26 27 28 29 30 31 32\n"
        + "33 34 35 36 37 38 39 40\n"
        + "41 42 43 44 45 46 47 48\n"
        + "49 50 51 52 53 54 55 56\n"
        + "57 58 59 60 61 62 63 64\n"
        + "1 1\n"
        + "2 2\n"
        + "3 1\n"
        + "4 2\n"
        + "5 2\n"
        + "6 1\n"
        + "7 1\n"
        + "8 2\n", "64 63 62 61 60 59 58 57 \n"
        + "56 55 54 53 52 51 50 49 \n"
        + "48 47 46 45 44 43 42 41 \n"
        + "40 39 38 37 36 35 34 33 \n"
        + "32 31 30 29 28 27 26 25 \n"
        + "24 23 22 21 20 19 18 17 \n"
        + "16 15 14 13 12 11 10 9 \n"
        + "8 7 6 5 4 3 2 1 \n");
    testCorrect("3 4\n"
        + "1 2 3 4 5 6 7 8\n"
        + "9 10 11 12 13 14 15 16\n"
        + "17 18 19 20 21 22 23 24\n"
        + "25 26 27 28 29 30 31 32\n"
        + "33 34 35 36 37 38 39 40\n"
        + "41 42 43 44 45 46 47 48\n"
        + "49 50 51 52 53 54 55 56\n"
        + "57 58 59 60 61 62 63 64\n"
        + "1 0\n"
        + "2 0\n"
        + "3 0\n"
        + "4 0\n", "1 2 3 4 5 6 7 8 \n"
        + "9 10 11 12 13 14 15 16 \n"
        + "17 18 19 20 21 22 23 24 \n"
        + "25 26 27 28 29 30 31 32 \n"
        + "33 34 35 36 37 38 39 40 \n"
        + "41 42 43 44 45 46 47 48 \n"
        + "49 50 51 52 53 54 55 56 \n"
        + "57 58 59 60 61 62 63 64 \n");
    testCorrect("3 4\n"
        + "1 2 3 4 5 6 7 8\n"
        + "9 10 11 12 13 14 15 16\n"
        + "17 18 19 20 21 22 23 24\n"
        + "25 26 27 28 29 30 31 32\n"
        + "33 34 35 36 37 38 39 40\n"
        + "41 42 43 44 45 46 47 48\n"
        + "49 50 51 52 53 54 55 56\n"
        + "57 58 59 60 61 62 63 64\n"
        + "5 0\n"
        + "6 0\n"
        + "7 0\n"
        + "8 0\n", "64 63 62 61 60 59 58 57 \n"
        + "56 55 54 53 52 51 50 49 \n"
        + "48 47 46 45 44 43 42 41 \n"
        + "40 39 38 37 36 35 34 33 \n"
        + "32 31 30 29 28 27 26 25 \n"
        + "24 23 22 21 20 19 18 17 \n"
        + "16 15 14 13 12 11 10 9 \n"
        + "8 7 6 5 4 3 2 1 \n");
    testCorrect("3 8\n"
        + "1 2 3 4 5 6 7 8\n"
        + "9 10 11 12 13 14 15 16\n"
        + "17 18 19 20 21 22 23 24\n"
        + "25 26 27 28 29 30 31 32\n"
        + "33 34 35 36 37 38 39 40\n"
        + "41 42 43 44 45 46 47 48\n"
        + "49 50 51 52 53 54 55 56\n"
        + "57 58 59 60 61 62 63 64\n"
        + "1 2\n"
        + "8 1\n"
        + "7 2\n"
        + "4 0\n"
        + "3 2\n"
        + "5 1\n"
        + "6 1\n"
        + "2 2\n", "45 37 47 39 41 33 43 35 \n"
        + "46 38 48 40 42 34 44 36 \n"
        + "61 53 63 55 57 49 59 51 \n"
        + "62 54 64 56 58 50 60 52 \n"
        + "13 5 15 7 9 1 11 3 \n"
        + "14 6 16 8 10 2 12 4 \n"
        + "29 21 31 23 25 17 27 19 \n"
        + "30 22 32 24 26 18 28 20 \n");
  }
}
