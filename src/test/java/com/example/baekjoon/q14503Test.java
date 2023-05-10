package com.example.baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class q14503Test {

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

    q14503.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
//    testCorrect("7 7\n"
//        + "4 2 1\n"
//        + "1 1 1 1 1 1 1\n"
//        + "1 0 0 0 1 0 1\n"
//        + "1 0 1 1 0 0 1\n"
//        + "1 0 0 0 0 1 1\n"
//        + "1 0 0 1 0 0 1\n"
//        + "1 0 0 0 0 0 1\n"
//        + "1 1 1 1 1 1 1", "11");
    testCorrect("9 7\n"
        + "6 2 1\n"
        + "1 1 1 1 1 1 1\n"
        + "1 0 1 0 1 0 1\n"
        + "1 0 1 0 0 0 1\n"
        + "1 0 1 0 1 0 1\n"
        + "1 0 1 1 1 1 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 0 0 1 1 0 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 1 1 1 1 1 1", "13");


    testCorrect("9 7\n"
        + "7 3 0\n"
        + "1 1 1 1 1 1 1\n"
        + "1 0 1 0 1 0 1\n"
        + "1 0 1 0 1 0 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 0 0 1 0 0 1\n"
        + "1 0 0 1 1 0 1\n"
        + "1 0 0 1 0 0 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 1 1 1 1 1 1", "25");
    testCorrect("9 7\n"
        + "3 4 2\n"
        + "1 1 1 1 1 1 1\n"
        + "1 0 1 0 1 0 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 0 0 1 1 0 1\n"
        + "1 0 0 0 1 0 1\n"
        + "1 1 0 1 1 1 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 1 1 1 1 1 1", "17");
    testCorrect("6 7\n"
        + "2 1 0\n"
        + "1 1 1 1 1 1 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 0 1 0 1 0 1\n"
        + "1 1 0 1 1 0 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 1 1 1 1 1 1", "15");
    testCorrect("11 10\n"
        + "7 4 0\n"
        + "1 1 1 1 1 1 1 1 1 1\n"
        + "1 0 0 0 0 0 0 0 0 1\n"
        + "1 0 0 0 1 1 1 1 0 1\n"
        + "1 0 0 1 1 0 0 0 0 1\n"
        + "1 0 1 1 0 0 0 0 0 1\n"
        + "1 0 0 0 0 0 0 0 0 1\n"
        + "1 0 0 0 0 0 0 1 0 1\n"
        + "1 0 0 0 0 0 1 1 0 1\n"
        + "1 0 0 0 0 0 1 1 0 1\n"
        + "1 0 0 0 0 0 0 0 0 1\n"
        + "1 1 1 1 1 1 1 1 1 1", "57");
    testCorrect("3 3\n"
        + "1 1 0\n"
        + "1 1 1\n"
        + "1 0 1\n"
        + "1 1 1", "1");
    testCorrect("5 5\n"
        + "1 2 3\n"
        + "1 1 1 1 1\n"
        + "1 0 0 0 1\n"
        + "1 0 1 0 1\n"
        + "1 0 0 0 1\n"
        + "1 1 1 1 1", "8");
    testCorrect("5 5\n"
        + "2 1 0\n"
        + "1 1 1 1 1\n"
        + "1 0 1 0 1\n"
        + "1 0 1 0 1\n"
        + "1 0 0 0 1\n"
        + "1 1 1 1 1", "6");
    testCorrect("7 7\n"
        + "2 2 2\n"
        + "1 1 1 1 1 1 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 0 0 1 0 0 1\n"
        + "1 0 0 1 0 0 1\n"
        + "1 0 0 1 0 0 1\n"
        + "1 0 0 0 0 0 1\n"
        + "1 1 1 1 1 1 1", "21");
  }
}
