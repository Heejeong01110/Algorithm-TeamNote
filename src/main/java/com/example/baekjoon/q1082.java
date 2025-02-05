package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q1082 {

  private static int N, M;
  private static int[] P;
  private static ArrayList<int[]> arr;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    P = new int[N];
    arr = new ArrayList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      P[i] = Integer.parseInt(st.nextToken());
      arr.add(new int[]{i, P[i]});
    }

    M = Integer.parseInt(br.readLine());
    br.close();
  }

  private static String Solution() {
    arr.sort((o1, o2) -> { //[0] : num, [1] : cost
      if (o1[1] == o2[1]) {
        return o2[0] - o2[1];
      }
      return o1[1] - o2[1];
    });

    int[] min;
    List<Integer> result = new ArrayList<>();
    if (arr.get(0)[0] == 0) {
      if (arr.size() == 1 || arr.get(1)[1] > M) {
        return "0";
      }
      min = arr.get(1);
    } else {
      min = arr.get(0);
    }
    M -= min[1];
    result.add(min[0]);

    while (M >= arr.get(0)[1]) {
      result.add(arr.get(0)[0]);
      M -= arr.get(0)[1];
    }

    //가능한 큰 수로 교체
    for (int i = 0; i < result.size(); i++) {
      for (int j = N - 1; j >= 0; j--) {
        if (P[j] <= M + P[result.get(i)]) {
          M += P[result.get(i)] - P[j];
          result.set(i, j);
          break;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int num : result) {
      sb.append(num);
    }

    return sb.toString();
  }

}
