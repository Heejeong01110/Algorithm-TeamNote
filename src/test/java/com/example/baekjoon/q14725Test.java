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

public class q14725Test {

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

    q14725.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3\n"
        + "2 B A\n"
        + "4 A B C D\n"
        + "2 A C", "A\n"
        + "--B\n"
        + "----C\n"
        + "------D\n"
        + "--C\n"
        + "B\n"
        + "--A\n");
    testCorrect("4\n"
        + "2 KIWI BANANA\n"
        + "2 KIWI APPLE\n"
        + "2 APPLE APPLE\n"
        + "3 APPLE BANANA KIWI", "APPLE\n"
        + "--APPLE\n"
        + "--BANANA\n"
        + "----KIWI\n"
        + "KIWI\n"
        + "--APPLE\n"
        + "--BANANA\n");
  }
}
