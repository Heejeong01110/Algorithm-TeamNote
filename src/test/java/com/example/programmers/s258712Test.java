package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s258712Test {

  @Test
  void solution() {
    assertEquals(2, s258712.solution(
        new String[]{"muzi", "ryan", "frodo", "neo"},
        new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi",
            "frodo muzi", "frodo ryan", "neo muzi"}
    ));

    assertEquals(4, s258712.solution(
        new String[]{"joy", "brad", "alessandro", "conan", "david"},
        new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro",
            "alessandro david"}
    ));
    assertEquals(0, s258712.solution(
        new String[]{"a", "b", "c"},
        new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}
    ));

  }
}
