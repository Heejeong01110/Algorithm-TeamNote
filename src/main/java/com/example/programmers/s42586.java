package com.example.programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//기능 개발
public class s42586 {

  public static int[] solution(int[] progresses, int[] speeds) {
    int[] answer;

    HashMap<Integer, Integer> dayMap = new HashMap<>();
    Integer day = 0;

    for (int i = 0; i < progresses.length; i++) {
      Integer prog = progresses[i] + day * speeds[i];
      while (prog < 100) {
        prog += speeds[i];
        day++;
      }
      dayMap.put(day, dayMap.getOrDefault(day, 0) + 1);
    }

    int index = 0;
    answer = new int[dayMap.size()];
    List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(dayMap.entrySet());
    entryList.sort(Comparator.comparingInt(Map.Entry::getKey));
    for (Map.Entry<Integer, Integer> entry : entryList) {
      answer[index++] = entry.getValue();
    }

    return answer;
  }
}
