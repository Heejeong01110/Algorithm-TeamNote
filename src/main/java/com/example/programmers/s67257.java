package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class s67257 {

  private String[] operator = new String[]{"-", "+", "*"};
  private long result;

  public long solution(String expression) {
    result = 0;

    dfs(0, new boolean[3], new int[]{-1, -1, -1}, expression);

    return result;
  }

  private void dfs(int depth, boolean[] visited, int[] res, String expression) {
    if (depth == 3) {
      result = Math.max(result, Math.abs(getCalculate(res, expression)));
    }

    for (int i = 0; i < 3; i++) {
      if (!visited[i]) {
        visited[i] = true;
        res[depth] = i;
        dfs(depth + 1, visited, res, expression);
        res[depth] = -1;
        visited[i] = false;
      }
    }

  }

  private long getCalculate(int[] calc, String expression) {
    String[] nums = expression.split("[^0-9]");
    String opes = expression.replaceAll("[0-9]", "");

    Deque<String> deque = new ArrayDeque<>();
    deque.addLast(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      deque.addLast(opes.substring(i - 1, i));
      deque.addLast(nums[i]);
    }

    for (int i = 0; i < 3; i++) {
      String nowFind = operator[calc[i]];

      long ans = Long.parseLong(deque.pollFirst());
      int size = deque.size();
      for (int s = 0; s < size / 2; s++) {
        String sign = deque.pollFirst();
        if (!nowFind.equals(sign)) {
          deque.addLast(String.valueOf(ans));
          deque.addLast(sign);
          ans = Long.parseLong(deque.pollFirst());
          continue;
        }

        long next = Long.parseLong(deque.pollFirst());
        switch (sign) {
          case "+" -> ans += next;
          case "-" -> ans -= next;
          case "*" -> ans *= next;
        }
      }
      deque.addLast(String.valueOf(ans));
    }

    return Long.parseLong(deque.pollFirst());
  }
}
