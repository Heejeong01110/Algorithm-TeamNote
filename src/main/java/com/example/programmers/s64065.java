package com.example.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class s64065 {

  public int[] solution(String s) {
    int[] answer = {};
    s = s.substring(2, s.length() - 2);
    String[] lists = s.split("},\\{");
    ArrayList<int[]> ary = new ArrayList<>();

    for (String list : lists) {
      String[] split = list.split(",");
      int[] add = new int[split.length];
      for (int i = 0; i < split.length; i++) {
        add[i] = Integer.parseInt(split[i]);
      }
      ary.add(add);
    }
    ary.sort((o1, o2) -> o2.length - o1.length);

    int cnt = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int[] now : ary) {
      for (int i = 0; i < now.length; i++) {
        map.put(now[i], map.getOrDefault(now[i], 0) + 1);
      }
    }

    int idx = 0;
    answer = new int[map.size()];
    List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
    entryList.sort((o1, o2) -> o2.getValue() - o1.getValue()); //value 내림차순 정렬
    for (Map.Entry<Integer, Integer> entry : entryList) {
      answer[idx++] = entry.getKey();
    }


    return answer;
  }

}
