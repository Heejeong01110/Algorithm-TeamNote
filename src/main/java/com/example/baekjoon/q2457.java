package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2457 {

  private static int N;
  private static Flower[] flowers;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    flowers = new Flower[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int three = Integer.parseInt(st.nextToken());
      int four = Integer.parseInt(st.nextToken());

      flowers[i] = new Flower(one * 100 + two, three * 100 + four);
    }

    br.close();
  }

  private static int Solution() {
    return greedy();
  }


  private static int greedy() {
    Arrays.sort(flowers, (o1, o2) -> {
      if (o1.start == o2.start) {
        return o1.end - o2.end;
      }
      return o1.start - o2.start;
    });

    int lastEnd = 301;
    int max = 0;
    int index = 0;
    int answer = 0;

    while (lastEnd < 1201) {
      max = 0;
      boolean flag = false;
      for (int i = index; i < N; i++) {
        Flower now = flowers[i];

        if (lastEnd < now.start) {
          break;
        }

        if (max < now.end) {
          index = i + 1;
          flag = true;
          max = now.end;
        }
      }

      if (flag) {
        lastEnd = max;
        answer++;
      } else {
        break;
      }

    }

    if (max < 1201) {
      return 0;
    }
    return answer;
  }

  private static class Flower {

    int start;
    int end;

    public Flower(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

}
