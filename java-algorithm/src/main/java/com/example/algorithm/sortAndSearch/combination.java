package com.example.algorithm.sortAndSearch;

public class combination {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3 };
    int r = 2;
    combination(arr, new boolean[arr.length], 0, 0, r);
    combination2(arr, new int[r], 0, 0, r);
  }
  // 서로 다른 n개에서 순서 없이 r개를 뽑는 경우의 수
  private static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
    if (depth == r) {
      for (int i = 0; i < arr.length; i++) {
        if (visited[i])
          System.out.print(arr[i]);
      }
      System.out.println();
      return;
    }
    for (int i = start; i < arr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        combination(arr, visited, i + 1, depth + 1, r);
        visited[i] = false;
      }
    }
  }

  // 서로 다른 n개에서 순서 없이, 중복이 가능하게 r개를 뽑는 경우의 수
  private static void combination2(int[] arr, int[] out, int start, int depth, int r) {
    if (depth == r) {
      for (int num : out){
        System.out.print(num);
      }
      System.out.println();
      return;
    }
    for (int i = start; i < arr.length; i++) {
      out[depth] = arr[i];
      combination2(arr, out, i, depth + 1, r);
    }
  }
}
