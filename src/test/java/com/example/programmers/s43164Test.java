package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s43164Test {

  @Test
  void solution() {

    assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"},
        s43164.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
    assertArrayEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"},
        s43164.solution(
            new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
                {"ATL", "SFO"}}));
  }
}
