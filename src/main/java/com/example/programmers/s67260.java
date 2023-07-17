package com.example.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class s67260 {

  public static boolean solution(int n, int[][] path, int[][] order) {
    ArrayList<Integer>[] map = new ArrayList[n];
    int[] reDir = new int[n];
    int[] save = new int[n];

    for (int i = 0; i < n; i++) {
      map[i] = new ArrayList<>();
    }

    for (int[] pat : path) {
      map[pat[0]].add(pat[1]);
      map[pat[1]].add(pat[0]);
    }

    for (int[] ord : order) {
      reDir[ord[1]] = ord[0];
    }

    if (reDir[0] != 0) {
      return false;
    }

    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[n];

    visited[0] = true;
    queue.addAll(map[0]);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      if (visited[now]) {
        continue;
      }

      if (!visited[reDir[now]]) {
        save[reDir[now]] = now;
        continue;
      }

      visited[now] = true;
      queue.addAll(map[now]);
      queue.add(save[now]);
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        return false;
      }
    }
    return true;
  }

}
