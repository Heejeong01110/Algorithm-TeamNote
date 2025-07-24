package com.example.baekjoon;

import java.util.stream.Stream;

class q13975Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
        2
        4
        40 30 30 50
        15
        1 21 3 4 5 35 5 4 3 5 98 21 14 17 32
        예제 출력 1\s
        300
        826
        """;
  }

}
