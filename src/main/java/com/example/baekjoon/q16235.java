package com.example.baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q16235 {

  private static int N;
  private static int[][] directs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1},
      {1, -1}, {-1, 1}};

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();

    int[][] A = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        A[i][j] = sc.nextInt();
      }
    }

    Tree[] trees = new Tree[M];
    for (int i = 0; i < M; i++) {
      trees[i] = new Tree(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }

    int[][] preMap = new int[N + 1][N + 1];
    int[][][] nextMap = new int[N + 1][N + 1][2];
    for (int i = 1; i <= N; i++) {
      Arrays.fill(preMap[i], 5);
    }

    int cnt = 0;
    PriorityQueue<Tree> preQueue = new PriorityQueue<>((o1, o2) -> o1.age - o2.age);
    PriorityQueue<Tree> nextQueue = new PriorityQueue<>((o1, o2) -> o1.age - o2.age);
    for (int i = 0; i < M; i++) {
      preQueue.add(trees[i]);
    }

    while (cnt < K) {
      while (!preQueue.isEmpty()) {
        Tree now = preQueue.poll();

        if (preMap[now.row][now.col] - nextMap[now.row][now.col][0]
            >= now.age) {//1. 자신의 나이만큼 양분을 먹고 나이가 1 증가
          nextMap[now.row][now.col][0] += now.age;
          nextQueue.add(new Tree(now.row, now.col, now.age + 1));

          if (now.age + 1 != 0 && (now.age + 1) % 5 == 0) {//3. 나이가 5의배수일 경우 인접한 8개 칸에 나이가 1인 나무가 번식
            for (int i = 0; i < 8; i++) {
              int nr = now.row + directs[i][0];
              int nc = now.col + directs[i][1];

              if (isPossible(nr, nc)) {
                nextQueue.add(new Tree(nr, nc, 1));
              }
            }
          }

        } else {//2. 죽은 나무일 경우 양분으로 변함 ((int) 나이 / 2) --> 하나씩 검사해서 원래 못자라는데 자라는 경우 발생
          nextMap[now.row][now.col][1] += now.age / 2;
        }
      }
      //4. A만큼 양분 추가
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          preMap[i][j] += A[i][j] - nextMap[i][j][0] + nextMap[i][j][1];
          nextMap[i][j][0] = 0;
          nextMap[i][j][1] = 0;
        }
      }

      preQueue.addAll(nextQueue);
      nextQueue.clear();
      cnt++;
    }

    System.out.println(preQueue.size());
  }

  private static boolean isPossible(int row, int col) {
    return row >= 1 && row <= N && col >= 1 && col <= N;
  }

  private static class Tree {

    int row;
    int col;
    int age;

    Tree(int row, int col, int age) {
      this.row = row;
      this.col = col;
      this.age = age;
    }
  }
}
