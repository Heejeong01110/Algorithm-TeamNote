package com.example.baekjoon;

import java.util.stream.Stream;

class q1436Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
        2
        예제 출력 1\s
        1666
        예제 입력 2\s
        3
        예제 출력 2\s
        2666
        예제 입력 3\s
        6
        예제 출력 3\s
        5666
        예제 입력 4\s
        187
        예제 출력 4\s
        66666
        예제 입력 5\s
        500
        예제 출력 5\s
        166699
        """;
  }


}
