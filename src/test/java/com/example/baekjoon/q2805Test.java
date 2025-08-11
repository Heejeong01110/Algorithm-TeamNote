package com.example.baekjoon;

import java.util.stream.Stream;

class q2805Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
              4 7
              20 15 10 17
              예제 출력 1\s
              15
              예제 입력 2\s
              5 20
              4 42 40 26 46
              예제 출력 2\s
              36
        """;
  }


}
