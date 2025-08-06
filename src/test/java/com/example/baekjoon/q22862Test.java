package com.example.baekjoon;

import java.util.stream.Stream;

class q22862Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of();
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
              8 2
              1 2 3 4 5 6 7 8
              예제 출력 1\s
              3
        """;
  }

}
