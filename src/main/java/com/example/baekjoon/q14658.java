package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q14658 {

  private static int N, M, L, K;
  private static int[][] inputs;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();

    int answer = 0;
    ArrayList<Star> stars = new ArrayList<>();
    for (int[] star : inputs) {
      stars.add(new Star(star[0], star[1]));
    }
    stars.sort((o1, o2) -> (o1.row + o1.col) - (o2.row + o2.col));

    while (!stars.isEmpty()) {
      answer++;
      int sr = N, sc = M;
      for (Star star : stars) {
        if (star.row - sr > L && star.col - sc > L) {
          break;
        }
        sr = Math.min(sr, star.row);
        sc = Math.min(sc, star.col);
      }

      int idx = 0;
      while (!stars.isEmpty()) {
        Star star = stars.get(idx);
        if (star.row - sr > L && star.col - sc > L) {
          break;
        }
        if (star.row >= sr && star.row <= sr + L && star.col >= sc && star.col <= sc + L) {
          stars.remove(star);
          idx--;
        }
        idx++;
      }
    }
    System.out.print(answer);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    inputs = new int[K][2];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      inputs[i][0] = Integer.parseInt(st.nextToken());
      inputs[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static class Star {

    int row;
    int col;

    public Star(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

}
