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

class q8972Test {

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

    q8972 q = new q8972();
    q.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("9 10\n"
        + "..........\n"
        + ".........R\n"
        + "..........\n"
        + "R.........\n"
        + "R...I.....\n"
        + "R.........\n"
        + "..........\n"
        + ".........R\n"
        + "....R.....\n"
        + "5558888", "....I.....\n"
        + "....R.....\n"
        + "..........\n"
        + "..........\n"
        + "..........\n"
        + "..........\n"
        + "..........\n"
        + "..........\n"
        + "..........");
    testCorrect("12 8\n"
        + "...I....\n"
        + "........\n"
        + "........\n"
        + "........\n"
        + "........\n"
        + "RR......\n"
        + "......RR\n"
        + "R......R\n"
        + "........\n"
        + "........\n"
        + "........\n"
        + "...R....\n"
        + "66445394444162", "kraj 11");
    testCorrect("4 5\n"
        + "I....\n"
        + ".....\n"
        + ".R.R.\n"
        + ".....\n"
        + "6", ".I...\n"
        + ".RR..\n"
        + ".....\n"
        + ".....");
  }
}
