package com.example.baekjoon;

import java.util.stream.Stream;

class q1937Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
        4
        14 9 12 10
        1 11 5 4
        7 15 2 13
        6 3 16 8
        예제 출력 1\s
        4
        """;
  }


}
