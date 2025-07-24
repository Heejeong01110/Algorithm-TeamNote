package com.example.baekjoon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class AsrTest {

  protected String defaultClassName;
  private OutputStream out;
  private InputStream in;

  // 1. 기본 Stream<TestCase> 방식 (선택적 override)
  protected static Stream<TestCase> testCases() {
    return Stream.empty();
  }

  // 2. "예제 입력/출력" 문자열 파싱 방식 (선택적 override)
  protected static String rawExampleData() {
    return null;
  }

  // 파라미터 소스: 두 방식 중 사용된 쪽 리턴
  public static Stream<TestCase> generateTestCases() {
    Stream<TestCase> cases = testCases();
    if (cases != null && cases.iterator().hasNext()) {
      return cases;
    }
    String raw = rawExampleData();
    if (raw != null) {
      return parseTestCasesFromRaw(raw);
    }
    return Stream.empty();
  }

  // "예제 입력 N"/"예제 출력 N" 텍스트 자동 파싱 함수
  static Stream<TestCase> parseTestCasesFromRaw(String raw) {
    List<TestCase> list = new ArrayList<>();
    String[] lines = raw.split("\n");

    List<String> currentInput = null, currentOutput = null;
    boolean readingInput = false, readingOutput = false;
    for (String line : lines) {
      if (line.trim().startsWith("예제 입력")) {
        // 입력 시작
        if (currentInput != null && currentOutput != null) {
          // 저장
          list.add(new TestCase(
              String.join("\n", currentInput).trim(),
              String.join("\n", currentOutput).trim()
          ));
        }
        currentInput = new ArrayList<>();
        currentOutput = null;
        readingInput = true;
        readingOutput = false;
      } else if (line.trim().startsWith("예제 출력")) {
        currentOutput = new ArrayList<>();
        readingInput = false;
        readingOutput = true;
      } else if (line.trim().startsWith("예제")) {
        // 주석 등 skip
        readingInput = false;
        readingOutput = false;
      } else if (readingInput) {
        currentInput.add(line);
      } else if (readingOutput) {
        currentOutput.add(line);
      }
    }
    // 마지막 케이스 추가
    if (currentInput != null && currentOutput != null) {
      list.add(new TestCase(
          String.join("\n", currentInput).trim(),
          String.join("\n", currentOutput).trim()
      ));
    }
    return list.stream();
  }

  @ParameterizedTest
  @MethodSource("generateTestCases")
  void testAllCases(TestCase testCase) throws Exception {
    if (defaultClassName == null) {
      String testClassName = this.getClass().getSimpleName();
      if (testClassName.endsWith("Test")) {
        defaultClassName = testClassName.substring(0, testClassName.length() - 4);
      } else {
        defaultClassName = testClassName;
      }
    }
    testCorrect(testCase.input, testCase.expectedOutput, defaultClassName);
  }

  protected void testCorrect(String input, String expectedOutput) throws Exception {
    if (defaultClassName == null) {
      throw new IllegalStateException("defaultClassName이 설정되지 않았습니다.");
    }
    testCorrect(input, expectedOutput, defaultClassName);
  }

  protected void testCorrect(String input, String expectedOutput, String className)
      throws Exception {
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    Class<?> clazz = Class.forName("com.example.baekjoon." + className);
    Method method = clazz.getMethod("main", String[].class);
    method.invoke(null, (Object) new String[]{});

    assertEquals(
        expectedOutput.replaceAll("\\r\\n?", "\n").trim(),
        out.toString().replaceAll("\\r\\n?", "\n").trim()
    );
  }

  static class TestCase {

    public final String input;
    public final String expectedOutput;

    public TestCase(String input, String expectedOutput) {
      this.input = input;
      this.expectedOutput = expectedOutput;
    }
  }
}
