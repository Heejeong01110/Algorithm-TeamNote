package com.example.programmers.exam;

public class ss1 {

  public static int solution(String s, int N) {
    int answer = -1;

    for (int i = 0; i < s.length() - N + 1; i++) {
      String now = s.substring(i, i + N);
      answer = Math.max(answer, check(now, N));
    }

    return answer;
  }

  private static Integer check(String now, int N) {
    boolean[] visited = new boolean[N + 1];
    for (int i = 0; i < N; i++) {
      int it = Integer.parseInt(now.substring(i, i + 1));
      if (it == 0 || it > N || visited[it]) {
        return -1;
      }
      visited[it] = true;
    }
    return Integer.parseInt(now);
  }
}
