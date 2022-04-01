package com.example.programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//주차 요금 계산
public class s92341 {

  public static int[] solution(int[] fees, String[] records) {
    int[] answer = {};
    HashMap<Integer, Integer> typeMap = new HashMap<>();
    HashMap<Integer, Integer> lastTimeMap = new HashMap<>();
    HashMap<Integer, Integer> totalTimeMap = new HashMap<>();

    for (int i = 0; i < records.length; i++) {
      String[] str = records[i].split(" ");

      int time = getTime(str[0]);
      int carNum = Integer.parseInt(str[1]);
      int type = str[2].equals("IN") ? 0 : 1;

      if (typeMap.getOrDefault(carNum, 1) == 1) {//들어오는 차 일 때
        lastTimeMap.put(carNum, time);
        typeMap.put(carNum, type);
      } else if (typeMap.get(carNum) == 0) { //들어온 기록이 있는 차일 때
        totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + (time - lastTimeMap.get(carNum)));
        typeMap.put(carNum, type);
        lastTimeMap.put(carNum, time);
      }
    }

    int last = getTime("23:59");
    for (int carNum : typeMap.keySet()) {
      if (typeMap.get(carNum) == 0) {
        totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum,0) + (last - lastTimeMap.get(carNum)));
        typeMap.put(carNum, 1);
        lastTimeMap.put(carNum, last);
      }
    }

    List<Map.Entry<Integer, Integer>> timeList = new LinkedList<>(totalTimeMap.entrySet());
    timeList.sort(Comparator.comparingInt(Map.Entry::getKey));

    answer = new int[timeList.size()];
    for (int i = 0; i < timeList.size(); i++) {
      answer[i] = getFee(fees, timeList.get(i).getValue());
    }

    return answer;
  }

  private static int getFee(int[] fees, Integer time) {
    int cost = fees[1];
    if (time > fees[0]) {
      time -= fees[0];
      int count = time / fees[2] + (time % fees[2] > 0 ? 1 : 0);
      cost += fees[3] * count;
    }
    return cost;
  }

  private static int getTime(String s) {
    String[] times = s.split(":");

    return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
  }
}
