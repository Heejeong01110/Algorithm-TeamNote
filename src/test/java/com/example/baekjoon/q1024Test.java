package com.example.baekjoon;

import java.util.stream.Stream;

class q1024Test extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
              18 2
              예제 출력 1\s
              5 6 7
              예제 입력 2\s
              18 4
              예제 출력 2\s
              3 4 5 6
              예제 입력 3\s
              18 5
              예제 출력 3\s
              -1
              예제 입력 4\s
              45 10
              예제 출력 4\s
              0 1 2 3 4 5 6 7 8 9
              예제 입력 5\s
              1000000000 2
              예제 출력 5\s
              199999998 199999999 200000000 200000001 200000002
        """;
  }


}
