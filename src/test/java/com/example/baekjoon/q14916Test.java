package com.example.baekjoon;

import java.util.stream.Stream;

class q14916Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
        13
        예제 출력 1\s
        5
        예제 입력 2\s
        14
        예제 출력 2\s
        4
        """;
  }


}
