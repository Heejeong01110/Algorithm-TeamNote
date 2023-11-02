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

class q1132Test {

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

    q1132 q = new q1132();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
//    testCorrect("2\n"
//        + "ABC\n"
//        + "BCA", "1875");
//    testCorrect("1\n"
//        + "ABCDEFGHIJ", "9876543210");
    testCorrect("2\n"
        + "ABCDEFGHIJ\n"
        + "J", "9876543202");
    testCorrect("10\n"
        + "A\n"
        + "BB\n"
        + "CCC\n"
        + "DDDD\n"
        + "EEEEE\n"
        + "FFFFFF\n"
        + "GGGGGGG\n"
        + "HHHHHHHH\n"
        + "IIIIIIIII\n"
        + "AJJJJJJJJJ", "9973936905");
    testCorrect("5\n"
        + "GHJIDDD\n"
        + "AHHCCCA\n"
        + "IIJCEJ\n"
        + "F\n"
        + "HDBIGFJAAJ", "9888114550");
  }
}
