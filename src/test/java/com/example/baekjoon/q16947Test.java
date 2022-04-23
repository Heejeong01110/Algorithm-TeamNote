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

public class q16947Test {

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

    q16947.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("6\n"
        + "1 2\n"
        + "3 4\n"
        + "6 4\n"
        + "2 3\n"
        + "1 3\n"
        + "3 5", "0 0 0 1 1 2 ");
    testCorrect("51\n"
        + "1 2\n"
        + "2 3\n"
        + "3 4\n"
        + "4 5\n"
        + "5 6\n"
        + "6 7\n"
        + "7 8\n"
        + "8 9\n"
        + "9 10\n"
        + "10 11\n"
        + "11 12\n"
        + "12 13\n"
        + "13 14\n"
        + "14 15\n"
        + "15 16\n"
        + "16 17\n"
        + "17 18\n"
        + "18 19\n"
        + "19 20\n"
        + "20 21\n"
        + "21 22\n"
        + "22 23\n"
        + "23 24\n"
        + "24 25\n"
        + "25 26\n"
        + "26 27\n"
        + "27 28\n"
        + "28 29\n"
        + "29 30\n"
        + "30 31\n"
        + "31 32\n"
        + "32 33\n"
        + "33 34\n"
        + "34 35\n"
        + "35 36\n"
        + "36 37\n"
        + "37 38\n"
        + "38 39\n"
        + "39 40\n"
        + "40 41\n"
        + "41 42\n"
        + "42 43\n"
        + "43 1\n"
        + "11 44\n"
        + "44 45\n"
        + "45 46\n"
        + "46 47\n"
        + "34 48\n"
        + "48 49\n"
        + "49 50\n"
        + "50 51", "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 2 3 4 1 2 3 4 ");
    testCorrect("38\n"
        + "1 2\n"
        + "2 3\n"
        + "3 4\n"
        + "4 5\n"
        + "5 6\n"
        + "6 1\n"
        + "1 7\n"
        + "7 8\n"
        + "8 9\n"
        + "9 10\n"
        + "10 11\n"
        + "11 12\n"
        + "12 13\n"
        + "13 14\n"
        + "14 15\n"
        + "15 16\n"
        + "16 17\n"
        + "17 18\n"
        + "18 19\n"
        + "19 20\n"
        + "20 21\n"
        + "21 22\n"
        + "22 23\n"
        + "23 24\n"
        + "24 25\n"
        + "25 26\n"
        + "26 27\n"
        + "27 28\n"
        + "28 29\n"
        + "29 30\n"
        + "30 31\n"
        + "31 32\n"
        + "32 33\n"
        + "33 34\n"
        + "34 35\n"
        + "35 36\n"
        + "36 37\n"
        + "37 38", "0 0 0 0 0 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 ");
    testCorrect("12\n"
        + "1 3\n"
        + "3 4\n"
        + "4 5\n"
        + "5 6\n"
        + "6 7\n"
        + "7 8\n"
        + "8 4\n"
        + "2 3\n"
        + "7 9\n"
        + "9 12\n"
        + "7 10\n"
        + "10 11", "2 2 1 0 0 0 0 0 1 1 2 2 ");
    testCorrect("4\n"
        + "1 3\n"
        + "4 3\n"
        + "4 2\n"
        + "1 2", "0 0 0 0 ");
  }
}
