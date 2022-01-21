package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s77486Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{360, 958, 108, 0, 450, 18, 180, 1080}, s77486.solution(
        new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
        new String[]{"young", "john", "tod", "emily", "mary"},
        new int[]{12, 4, 2, 5, 10}
    ));

    assertArrayEquals(new int[]{0, 110, 378, 180, 270, 450, 0, 0}, s77486.solution(
        new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
        new String[]{"sam", "emily", "jaimie", "edward"},
        new int[]{2, 3, 5, 4}
    ));
  }
}
