package com.example.programmers;

import java.util.HashMap;

public class s258709 {

  private static int n;
  private static double maxPer;
  private static int maxIdx;
  private static double[] checked;
  private static HashMap<Integer, Integer>[] dices;

  public static int[] solution(int[][] dice) {
    n = dice.length;
    maxPer = 0.0;
    maxIdx = 0;

    dices = new HashMap[n];
    for (int i = 0; i < n; i++) {
      dices[i] = new HashMap<>();
      for (int j = 0; j < 6; j++) {
        dices[i].put(dice[i][j], dices[i].getOrDefault(dice[i][j], 0) + 1);
      }
    }

    checked = new double[2049];
    comb(n, n / 2, 0, 0, new int[n / 2]);

    return toList(maxIdx);
  }

  private static int[] toList(int binary) {
    int[] res = new int[n / 2];
    String s = Integer.toBinaryString(binary);
    int now = 0;
    for (int i = 0; i < s.length(); i++) {
      int idx = s.length() - 1 - i;
      if (s.charAt(idx) == '1') {
        res[now++] = i + 1;
      }
    }
    return res;
  }

  private static void comb(int n, int c, int now, int depth, int[] list) {
    if (depth == c) {
      //조합 완성
      int idx = toBinary(list);
      int revIdx = toBinary(toRev(list));

      if (checked[idx] == 0) {
        double[] res = getScore(list);
        checked[idx] = res[0];
        checked[revIdx] = res[1];
        if (maxPer < checked[idx]) {
          maxPer = checked[idx];
          maxIdx = idx;
        }
        if (maxPer < checked[revIdx]) {
          maxPer = checked[revIdx];
          maxIdx = revIdx;
        }
      }
      return;
    }

    for (int i = now; i < n; i++) {
      list[depth] = i;
      comb(n, c, i + 1, depth + 1, list);
    }
  }

  private static double[] getScore(int[] list) {
    int[] cnt = new int[3];//이김, 무승부, 비김
    HashMap<Integer, Integer> aDice = getAllNum(list);
    HashMap<Integer, Integer> bDice = getAllNum(toRev(list));

    for (Integer a_key : aDice.keySet()) {
      for (Integer b_key : bDice.keySet()) {
        int num = aDice.get(a_key) * bDice.get(b_key);
        if (a_key > b_key) {
          cnt[0] += num;
        } else if (a_key < b_key) {
          cnt[2] += num;
        } else {
          cnt[1] += num;
        }
      }
    }

    double[] result = new double[2];
    result[0] = (1.0) * cnt[0] / (cnt[0] + cnt[1] + cnt[2]);
    result[1] = (1.0) * cnt[2] / (cnt[0] + cnt[1] + cnt[2]);
    return result;
  }

  private static HashMap<Integer, Integer> getAllNum(int[] list) {
    HashMap<Integer, Integer> res = (HashMap<Integer, Integer>) dices[list[0]].clone();
    HashMap<Integer, Integer> tmp = new HashMap<>();
    for (int i = 1; i < list.length; i++) {
      for (Integer key : res.keySet()) {
        for (Integer plus : dices[list[i]].keySet()) {
          tmp.put(key + plus,
              tmp.getOrDefault(key + plus, 0) + res.get(key) * dices[list[i]].get(plus));
        }
      }
      res.clear();
      res.putAll(tmp);
      tmp.clear();
    }

    return res;
  }

  private static int toBinary(int[] list) {
    int res = 0;
    for (int num : list) {
      res += Math.pow(2, num);
    }
    return res;
  }

  private static int[] toRev(int[] list) {
    int[] res = new int[list.length];
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n / 2; i++) {
      visited[list[i]] = true;
    }
    int idx = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        res[idx++] = i;
      }
    }
    return res;
  }

}
