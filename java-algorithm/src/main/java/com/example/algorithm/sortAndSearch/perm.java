package com.example.algorithm.sortAndSearch;

public class perm {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3 };
    int r = 2;
    permutation(arr, new int[r], new boolean[arr.length], 0, r);
    permutation2(arr, new int[r], 0, r);
  }
  
  // 서로 다른 n개 에서 r개를 뽑아서 정렬하는 경우의 수
  private static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
    if (depth == r) {
      for (int num : out)
        System.out.print(num);
      System.out.println();
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        out[depth] = arr[i];
        permutation(arr, out, visited, depth + 1, r);
        visited[i] = false;
      }
    }
  }


  // 서로 다른 n개에서 중복이 가능하게 r개를 뽑아서 정렬하는 경우의 수
  private static void permutation2(int[] arr, int[] out, int depth, int r) {
    if (depth == r) {
      for (int num : out)
        System.out.print(num);
      System.out.println();
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      out[depth] = arr[i];
      permutation2(arr, out, depth + 1, r);
    }
  }
}
