package com.example.baekjoon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class q21942Test {

  private static OutputStream out;
  private static InputStream in;

  @BeforeAll
  static void setting() {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
  }

  private void testCorrect(String input, String output) throws IOException, ParseException {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    q21942.run();

    assertEquals(output, out.toString());
  }


  @Test
  void main() throws IOException, ParseException {
    testCorrect("16 001/00:00 4000\n"
        + "2021-01-01 09:12 arduino tony9402\n"
        + "2021-12-31 13:24 arduino tony9402\n"
        + "2021-01-23 14:04 raspberrypi tony9402\n"
        + "2021-02-01 18:21 resistance amsminn\n"
        + "2021-02-03 23:14 transistor codethinking\n"
        + "2021-02-28 23:55 transistor codethinking\n"
        + "2021-02-09 12:45 resistance amsminn\n"
        + "2021-02-13 14:37 raspberrypi tony9402\n"
        + "2021-01-01 09:12 arduino tony9402\n"
        + "2021-01-13 13:24 arduino tony9402\n"
        + "2021-02-15 12:12 raspberrypi q540jh\n"
        + "2021-02-15 12:13 raspberrypi q540jh\n"
        + "2021-01-01 09:12 arduino tony9402\n"
        + "2021-01-01 09:13 monitor chansol\n"
        + "2021-01-01 09:18 arduino tony9402\n"
        + "2021-01-01 09:18 monitor chansol\n", "amsminn 38976000\n"
        + "codethinking 138404000\n"
        + "tony9402 2271588000");
    testCorrect("8 014/00:00 5\n"
        + "2021-01-01 09:12 arduino tony9402\n"
        + "2021-01-13 13:24 arduino tony9402\n"
        + "2021-01-23 14:04 raspberrypi tony9402\n"
        + "2021-02-01 18:21 resistance amsminn\n"
        + "2021-02-03 23:14 transistor codethinking\n"
        + "2021-02-08 22:14 transistor codethinking\n"
        + "2021-02-09 12:45 resistance amsminn\n"
        + "2021-02-13 14:37 raspberrypi tony9402\n", "tony9402 50565");
    testCorrect("4 015/00:00 5\n"
        + "2021-01-01 09:12 arduino tony9402\n"
        + "2021-01-13 13:24 arduino tony9402\n"
        + "2021-02-15 12:12 raspberrypi q540jh\n"
        + "2021-02-15 12:13 raspberrypi q540jh\n", "-1");
    testCorrect("4 000/00:05 1\n"
        + "2021-01-01 09:12 arduino tony9402\n"
        + "2021-01-01 09:13 monitor chansol\n"
        + "2021-01-01 09:18 arduino tony9402\n"
        + "2021-01-01 09:18 monitor chansol", "tony9402 1");
  }
}
