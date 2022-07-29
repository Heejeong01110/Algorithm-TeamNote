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

public class q1062Test {

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

    q1062.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("3 6\n"
        + "antarctica\n"
        + "antahellotica\n"
        + "antacartica", "2");
    testCorrect("2 3\n"
        + "antaxxxxxxxtica\n"
        + "antarctica", "0");
    testCorrect("9 8\n"
        + "antabtica\n"
        + "antaxtica\n"
        + "antadtica\n"
        + "antaetica\n"
        + "antaftica\n"
        + "antagtica\n"
        + "antahtica\n"
        + "antajtica\n"
        + "antaktica", "3");
  }
}
