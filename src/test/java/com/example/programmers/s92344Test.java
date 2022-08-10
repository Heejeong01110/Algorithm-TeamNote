package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s92344Test {

  @Test
  void solution() {
    assertEquals(6, s92344.solution(
        new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}},
        new int[][]{
            {1, 1, 1, 2, 2, 4},
            {1, 0, 0, 1, 1, 2},
            {2, 2, 0, 2, 0, 100}}));
    assertEquals(10, s92344.solution(
        new int[][]{
            {5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5}},
        new int[][]{
            {1, 0, 0, 3, 4, 4},
            {1, 2, 0, 2, 3, 2},
            {2, 1, 0, 3, 1, 2},
            {1, 0, 1, 3, 3, 1}}));
  }
}
