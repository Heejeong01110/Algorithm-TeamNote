package com.example.baekjoon;

import java.util.stream.Stream;

class q2230Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
        3 3
        1
        5
        3
        예제 출력 1\s
        4
        """;
  }


}
