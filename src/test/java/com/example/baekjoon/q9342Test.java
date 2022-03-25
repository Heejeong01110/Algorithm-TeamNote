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

public class q9342Test {

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

    q9342.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("15\n"
        + "AFC\n"
        + "AAFC\n"
        + "AAAFFCC\n"
        + "AAFCC\n"
        + "BAFC\n"
        + "QWEDFGHJMNB\n"
        + "DFAFCB\n"
        + "ABCDEFC\n"
        + "DADC\n"
        + "SDFGHJKLQWERTYU\n"
        + "AAAAAAAAAAAAABBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCDDDDDDDDDDDEEEEEEEEEEEEEEEFFFFFFFFC\n"
        + "AAAFFFFFBBBBCCCAAAFFFF\n"
        + "ABCDEFAAAFFFCCCABCDEF\n"
        + "AFCP\n"
        + "AAFFCPP", "Infected!\n"
        + "Infected!\n"
        + "Infected!\n"
        + "Infected!\n"
        + "Infected!\n"
        + "Good\n"
        + "Good\n"
        + "Good\n"
        + "Good\n"
        + "Good\n"
        + "Good\n"
        + "Good\n"
        + "Good\n"
        + "Good\n"
        + "Good\n");
  }
}
