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

class q11066Test {

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

    q11066.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
//    testCorrect("2\n"
//        + "15\n"
//        + "1 21 3 4 5 35 5 4 3 5 98 21 14 17 32\n"
//        + "4\n"
//        + "40 30 30 50\n", "864\n"
//        + "300\n"
//    );
    testCorrect("2\n"
        + "4\n"
        + "40 30 30 50\n"
        + "15\n"
        + "1 21 3 4 5 35 5 4 3 5 98 21 14 17 32\n", "300\n"
        + "864\n"
    );
  }
}
