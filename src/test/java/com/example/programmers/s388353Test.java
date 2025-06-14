package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s388353Test {

  @Test
  void solution() {
    assertEquals(11,
        s388353.solution(new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"},
            new String[]{"A", "BB", "A"}));
    assertEquals(4,
        s388353.solution(new String[]{"HAH", "HBH", "HHH", "HAH", "HBH"},
            new String[]{"C", "B", "B", "B", "B", "H"}));

  }

}
