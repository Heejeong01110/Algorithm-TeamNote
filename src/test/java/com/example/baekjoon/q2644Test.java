package com.example.baekjoon;

import java.util.stream.Stream;

class q2644Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
        9
        7 3
        7
        1 2
        1 3
        2 7
        2 8
        2 9
        4 5
        4 6
        예제 출력 1\s
        3
        예제 입력 2\s
        9
        8 6
        7
        1 2
        1 3
        2 7
        2 8
        2 9
        4 5
        4 6
        예제 출력 2\s
        -1
        """;
  }


}
