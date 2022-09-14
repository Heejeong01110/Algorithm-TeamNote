package com.example.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class s70130 {

  public static int solution(int[] a) {
    int answer = 0;
    HashMap<Integer, Integer> countMap = new HashMap<>();

    for (int value : a) {
      countMap.put(value, countMap.getOrDefault(value, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(countMap.entrySet());
    entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

    for (int i = 0; i < entryList.size(); i++) {
      int value = entryList.get(i).getKey();
      if (entryList.get(i).getValue() * 2 < answer) {
        break;
      }

      int count = 0;
      boolean[] temp = new boolean[]{false, false}; //0 : value체크,  1 : 나머지 체크

      for (int j = 0; j < a.length; j++) {

        if (a[j] == value) { //교집합 값일 때
          temp[0] = true;
        } else { //교집합 외의 값일 때
          temp[1] = true;
        }

        if (temp[0] && temp[1]) {
          temp[0] = false;
          temp[1] = false;
          count += 2;
        }

      }

      answer = Math.max(answer, count);
    }

    return answer;
  }
}
