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

public class q5670Test {

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

    q5670.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("4\n"
        + "hello\n"
        + "hell\n"
        + "heaven\n"
        + "goodbye\n"
        + "3\n"
        + "hi\n"
        + "he\n"
        + "h\n"
        + "7\n"
        + "structure\n"
        + "structures\n"
        + "ride\n"
        + "riders\n"
        + "stress\n"
        + "solstice\n"
        + "ridiculous", "2.00\n"
        + "1.67\n"
        + "2.71\n");
  }
}
