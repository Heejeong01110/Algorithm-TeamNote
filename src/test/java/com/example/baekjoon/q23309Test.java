package com.example.baekjoon;

import java.util.stream.Stream;

class q23309Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
        4 4
        2 7 3 5
        BN 5 11
        BP 3 6
        CP 2
        CN 7
        예제 출력 1\s
        2
        7
        11
        6
        """;
  }


}
