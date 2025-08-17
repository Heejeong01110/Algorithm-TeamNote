package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q23309 {

  private static ArrayList<Integer> stations;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    stations = new ArrayList<>();
    visited = new boolean[1_000_000];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int e = Integer.parseInt(st.nextToken());
      stations.add(e);
      visited[e] = true;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      String cmd = br.readLine().trim();
      String[] spl = cmd.split(" ");

      int idx = findIdx(Integer.parseInt(spl[1]));

      if (spl[0].equals("BN") && !visited[Integer.parseInt(spl[2])]) {
        sb.append(stations.get(toIdx(idx + 1))).append("\n");
        insert(toIdx(idx + 1), Integer.parseInt(spl[2]));
      } else if (spl[0].equals("BP") && !visited[Integer.parseInt(spl[2])]) {
        sb.append(stations.get(toIdx(idx - 1))).append("\n");
        insert(idx, Integer.parseInt(spl[2]));
      } else if (spl[0].equals("CN")) {
        sb.append(stations.get(toIdx(idx + 1))).append("\n");
        delete(toIdx(idx + 1));
      } else if (spl[0].equals("CP")) {
        sb.append(stations.get(toIdx(idx - 1))).append("\n");
        delete(toIdx(idx - 1));
      }
    }
    System.out.print(sb);
    br.close();
  }

  private static int toIdx(int idx) {
    if (idx == -1) {
      idx = stations.size() - 1;
    } else if (idx == stations.size()) {
      idx = 0;
    }
    return idx;
  }

  private static void insert(int idx, int num) {
    stations.add(idx, num);
    visited[num] = true;
  }

  private static void delete(int idx) {
    if (idx == -1) {
      idx = stations.size() - 1;
    } else if (idx == stations.size()) {
      idx = 0;
    }
    visited[stations.get(idx)] = false;
    stations.remove(idx);
  }

  private static int findIdx(int num) {
    return stations.indexOf(num);
  }

}
