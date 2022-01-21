package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s60059Test {

  @Test
  void solution() {
//    assertEquals(true, s60059.solution(
//        new int[][]{
//            {0, 0, 0},
//            {1, 0, 0},
//            {0, 1, 1}},
//        new int[][]{
//            {1, 1, 1},
//            {1, 1, 0},
//            {1, 0, 1}}
//    ));
    assertEquals(true, s60059.solution(
        new int[][]{
            {0, 0, 0},
            {1, 0, 0},
            {0, 1, 1}},
        new int[][]{
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 0},
            {1, 1, 0, 1}}
    ));

  }
}
