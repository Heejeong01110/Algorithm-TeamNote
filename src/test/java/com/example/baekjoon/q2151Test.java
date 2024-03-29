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

public class q2151Test {

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

    q2151.run();

    assertEquals(output,out.toString());
  }


  @Test
  void main() throws IOException {
    testCorrect("5\n"
        + "!.!.!\n"
        + ".....\n"
        + ".*...\n"
        + ".*...\n"
        + "#.!*#","2");
testCorrect("50\n"
    + "#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    + "*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#","2");
    testCorrect("9\n"
        + ".!*......\n"
        + "..!.!*!.!\n"
        + "#.!*.*.*.\n"
        + "!!.*!.!*.\n"
        + ".*.......\n"
        + ".#......!\n"
        + ".........\n"
        + ".........\n"
        + "!.......!", "3");
    testCorrect("20\n"
        + "#.....!.!...........\n"
        + "******.*.***********\n"
        + "*!....!*.***********\n"
        + "*.****.*.***********\n"
        + "*.**!.!*.***********\n"
        + "*.**.***.***********\n"
        + "*.**!.!*.***********\n"
        + "*.****.*.***********\n"
        + "*.**!.!*.***********\n"
        + "*.**.***.***********\n"
        + "*!..!.......#*******\n"
        + "********.***.*******\n"
        + "********.***.*******\n"
        + "********.***.*******\n"
        + "********.***.*******\n"
        + "********.*!.!*******\n"
        + "********.*.*********\n"
        + "********.*!.!*******\n"
        + "********.***.*******\n"
        + "********!...!*******", "4");
    testCorrect("3\n"
        + "#!.\n"
        + "!!.\n"
        + "*#.", "1");
    testCorrect("3\n"
        + "...\n"
        + "*!#\n"
        + "#!!", "1");
    testCorrect("2\n"
        + "!#\n"
        + "!#", "0");
    testCorrect("30\n"
        + "#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#", "1");

    testCorrect("8\n"
        + "***#****\n"
        + "*!.!..!*\n"
        + "*......*\n"
        + "*..*...*\n"
        + "*!!....*\n"
        + "*.!!..!*\n"
        + "*......*\n"
        + "***#****", "4");
    testCorrect("5\n"
        + "*****\n"
        + "*#.!*\n"
        + "*...*\n"
        + "*!.!#\n"
        + "*****", "1");
    testCorrect("5\n"
        + "***#!\n"
        + "*.*..\n"
        + "*!.*.\n"
        + "*!..!\n"
        + "*#***", "3");
    testCorrect("5\n"
        + "***#*\n"
        + "*.!.*\n"
        + "*!.!*\n"
        + "*.!.*\n"
        + "*#***", "2");
  }
}
