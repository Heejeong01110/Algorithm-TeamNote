package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q9019 {

  private static int T;
  private static int[][] nums;
  private static final Character[] Alpa = new Character[]{'D', 'S', 'L', 'R'};
  private static StringBuilder sb;
  private static String[] answer;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());
    nums = new int[T][2];

    StringTokenizer st;
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      nums[i][0] = Integer.parseInt(st.nextToken());
      nums[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static String Solution() {
    sb = new StringBuilder();
    answer = new String[T];

    for (int t = 0; t < T; t++) {
      boolean[] visited = new boolean[10000];
      String[] str = new String[10000];
      for(int i=0;i<10000;i++){
        str[i] = "";
      }

      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(nums[t][0]);
      visited[nums[t][0]] = true;

      while (!queue.isEmpty()) {
        int now = queue.poll();

        if (now == nums[t][1]) {
          answer[t] = str[now];
          break;
        }

        int[] newNum = new int[4];
        newNum[0] = (now * 2 < 10000) ? now * 2 : ((now * 2) % 10000);//D
        newNum[1] = (now - 1 < 0) ? 9999 : (now - 1);//S
        newNum[2] = now / 1000 + (now % 1000) * 10;//L
        newNum[3] = (now % 10) * 1000 + now / 10;//R

        for (int i = 0; i < 4; i++) {
          if (!visited[newNum[i]]) {
            queue.add(newNum[i]);
            visited[newNum[i]] = true;
            str[newNum[i]] = str[now] + Alpa[i];
          }
        }
      }

      sb.append(answer[t]).append("\n");
    }

    return sb.toString();
  }

}
