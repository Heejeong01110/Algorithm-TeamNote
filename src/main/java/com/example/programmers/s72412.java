package com.example.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class s72412 {

  private HashMap<String, ArrayList<Integer>> map;

  public int[] solution(String[] info, String[] query) {
    int[] answer = new int[query.length];
    map = new HashMap<>();

    for (String user : info) {
      String[] userInfo = user.split(" ");
      addKey(userInfo, 0, "");
    }
    for (String key : map.keySet()) {
      map.get(key).sort(Comparator.naturalOrder());
    }

    for (int i = 0; i < query.length; i++) {
      String str = query[i].replace(" and ", "");

      String[] keyAndValue = str.split(" ");
      answer[i] = map.containsKey(keyAndValue[0]) ?
          binarySearch(keyAndValue[0], Integer.parseInt(keyAndValue[1])) : 0;
    }

    return answer;
  }

  private int binarySearch(String key, int score) {
    ArrayList<Integer> list = map.get(key);
    int start = 0, end = list.size() - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (list.get(mid) < score) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return list.size() - start;
  }

  private void addKey(String[] userInfo, int idx, String str) {
    if (idx == 4) {
      ArrayList<Integer> list = map.getOrDefault(str, new ArrayList<>());
      list.add(Integer.parseInt(userInfo[4]));
      map.put(str, list);
      return;
    }

    addKey(userInfo, idx + 1, str + "-");
    addKey(userInfo, idx + 1, str + userInfo[idx]);
  }

}
