package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class q6137 {

  private static int N;
  private static ArrayList<Character> result;
  private static char[] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    Solution();
  }

  private static void Solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    StringBuilder input = new StringBuilder();

    inp = new char[N];
    for (int i = 0; i < N; i++) {
      inp[i] = br.readLine().charAt(0);
    }

    int start = 0;
    int end = N - 1;

    result = new ArrayList<>();

    while (start <= end) {
      if (inp[start] > inp[end]) {
        result.add(inp[end]);
        end--;

      } else if (inp[start] < inp[end]) {
        result.add(inp[start]);
        start++;

      } else {

        int front = start, back = end;
        boolean check = true;

        while (inp[front] == inp[back]) {
          if (back > 0) {
            back--;
          }
          if (front < N - 1) {
            front++;
          }

          if (inp[front] < inp[back]) {
            check = true;
          } else if (inp[front] > inp[back]) {
            check = false;
          }
        }

        if (check) {
          result.add(inp[start]);
          start++;
        } else {
          result.add(inp[end]);
          end--;
        }
      }
    }

    for (int i = 0; i < result.size(); i++) {
      if (i % 80 == 0 && i != 0) {
        System.out.println();
      }
      System.out.print(result.get(i));
    }

    br.close();
  }

}
