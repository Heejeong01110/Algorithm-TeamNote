package com.example.baekjoon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest {

  // 기본으로 사용할 클래스명 (각 테스트 클래스에서 지정 가능)
  protected String defaultClassName;
  private OutputStream out;
  private InputStream in;

  @BeforeEach
  void autoSetDefaultClassName() {
    // 이미 지정되어 있으면 건너뜀 (직접 지정 우선)
    if (defaultClassName != null) {
      return;
    }

    // 현재 실행 중인 테스트 클래스명 얻기
    String testClassName = this.getClass().getSimpleName();

    // 'Test'로 끝나면 잘라서 설정
    if (testClassName.endsWith("Test")) {
      defaultClassName = testClassName.substring(0, testClassName.length() - 4);
    } else {
      defaultClassName = testClassName;
    }
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
    Method method = clazz.getMethod("run");
    method.invoke(null);

    assertEquals(expectedOutput, out.toString());
  }
}
