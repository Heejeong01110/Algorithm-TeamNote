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

class q13701Test {

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

    q13701 q = new q13701();
    q.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("12 1 449 12 555 1201 912 555 19372", "12 1 449 555 1201 912 19372");
    testCorrect("21003957 20891590 11382885 18340118 11354168 5461061 12693617 2552341 14639514 25224366 19239852 136782 17206566 18675414 9536557 24961835 2507460 32083310 4485200 19506627 21087117 9270314 12953612 10216350 8170712 20436397 11382885 29305594 27169105",
        "21003957 20891590 11382885 18340118 11354168 5461061 12693617 2552341 14639514 25224366 19239852 136782 17206566 18675414 9536557 24961835 2507460 32083310 4485200 19506627 21087117 9270314 12953612 10216350 8170712 20436397 29305594 27169105");
  }
}
