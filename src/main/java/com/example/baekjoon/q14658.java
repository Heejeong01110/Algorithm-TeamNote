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

    ArrayList<Star> stars = new ArrayList<>();
    for (int[] star : inputs) {
      stars.add(new Star(star[0], star[1]));
    }

    int answer = 0;
    for (int i = 0; i < stars.size(); i++) {
      for (int j = 0; j < stars.size(); j++) {
        Star s1 = stars.get(i);
        Star s2 = stars.get(j);

        int cnt = 0;
        for (Star s3 : stars) {
          if (s3.row >= s1.row && s3.row <= s1.row + L && s3.col >= s2.col && s3.col <= s2.col + L) {
            cnt++;
          }
        }
        answer = Math.max(answer, cnt);
      }
    }

    System.out.print(stars.size() - answer);
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
