package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q1707 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());

    for (int k = 0; k < K; k++) {
      System.out.println(check(getMap()) ? "YES" : "NO");
    }

    br.close();
  }

  private static HashMap<Integer, ArrayList<Integer>> getMap() throws IOException {
    int V, E;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= V; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int e = 0; e < E; e++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      map.get(one).add(two);
      map.get(two).add(one);
    }
    return map;
  }

  private static boolean check(HashMap<Integer, ArrayList<Integer>> map) {
    
    return false;
  }

}
