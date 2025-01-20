package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s17683Test {

  @Test
  void solution() {
    assertEquals("HELLO", s17683.solution("ABCDEFG",
        new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    assertEquals("FOO", s17683.solution("CC#BCC#BCC#BCC#B",
        new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
    assertEquals("WORLD", s17683.solution("ABC",
        new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
  }
}
