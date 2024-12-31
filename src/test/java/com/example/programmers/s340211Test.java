package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s340211Test {

  @Test
  void solution() {
    assertEquals(1, s340211.solution(
        new int[][]{
            {3, 2}, {6, 4}, {4, 7}, {1, 4}},
        new int[][]{
            {4, 2}, {1, 3}, {2, 4}}));
    assertEquals(9, s340211.solution(
        new int[][]{
            {3, 2}, {6, 4}, {4, 7}, {1, 4}},
        new int[][]{
            {4, 2}, {1, 3}, {4, 2}, {4, 3}}));
  }
}
