package com.example.baekjoon;

import java.util.stream.Stream;

public class AsrRunTest extends AsrTest {

  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> direct = Stream.of(
        new TestCase("7 2\n-37 2 -6 -39 -29 11 -28", "131"),
        new TestCase("8 3\n-18 -9 -4 50 22 -26 40 -45", "158")
    );
    return Stream.concat(direct, parseTestCasesFromRaw(rawExampleData()));
  }

  protected static String rawExampleData() {
    return """
        예제 입력 1\s
           7 2
           -37 2 -6 -39 -29 11 -28
           예제 출력 1\s
           131
        """;
  }

}
