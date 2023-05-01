package com.example.programmers;

import java.util.ArrayList;
import java.util.Comparator;

public class s131130 {

  public int solution(int[] cards) {
    int[] newCards = new int[cards.length + 1];
    ArrayList<Integer> memo = new ArrayList<>();

    for (int i = 0; i < cards.length; i++) {
      newCards[i + 1] = cards[i];
    }

    boolean[] visited = new boolean[cards.length + 1];
    for (int i = 1; i < cards.length + 1; i++) {
      if (!visited[i]) {
        memo.add(getSum(newCards, i, visited));
      }
    }

    if (memo.size() <= 1) {
      return 0;
    }

    memo.sort(Comparator.reverseOrder());
    return memo.get(0) * memo.get(1);
  }

  private int getSum(int[] cards, int idx, boolean[] visited) {
    if (!visited[idx]) {
      visited[idx] = true;
      return 1 + getSum(cards, cards[idx], visited);
    }

    return 0;
  }


}
