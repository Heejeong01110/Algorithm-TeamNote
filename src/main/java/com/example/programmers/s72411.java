package com.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class s72411 {

  private static HashMap<String, Integer> count;

  public static String[] solution(String[] orders, int[] course) {
    ArrayList<String> allList = new ArrayList<>();
    for (int i = 0; i < course.length; i++) {
      count = new HashMap<>();

      for (int j = 0; j < orders.length; j++) {
        comb(orders[j], new boolean[orders[j].length()], 0, 0, course[i]);
      }

      List<Map.Entry<String, Integer>> entryList = new LinkedList<>(count.entrySet());
      entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
      int maxCount = entryList.isEmpty() ? 0 : entryList.get(0).getValue();
      for (int j = 0; j < entryList.size(); j++) {
        if (entryList.get(j).getValue() == maxCount && maxCount >= 2) {
          allList.add(entryList.get(j).getKey());
        } else {
          break;
        }
      }
    }
    String[] answer = new String[allList.size()];
    allList.sort(Comparator.naturalOrder());

    for (int i = 0; i < allList.size(); i++) {
      answer[i] = allList.get(i);
    }
    return answer;
  }

  private static void comb(String order, boolean[] visited, int start, int depth, int r) {
    if (depth == r) {
      char[] orders = order.toCharArray();
      Arrays.sort(orders);

      String str = "";
      for (char c : orders) {
        str += c;
      }
      count.put(str, count.getOrDefault(str, 0) + 1);
      return;
    }
    for (int i = start; i < order.length(); i++) {
      if (!visited[i]) {
        visited[i] = true;
        comb(order, visited, i + 1, depth + 1, r);
        visited[i] = false;
      }
    }
  }
}
