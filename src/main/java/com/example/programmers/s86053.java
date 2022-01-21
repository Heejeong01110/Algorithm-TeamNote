package com.example.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class s86053 {

  private static int maxTime;
  private static int totalGold = 0;
  private static int totalSilver = 0;
  private static int[] gold;
  private static int[] silver;

  public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
    maxTime = 0;
    totalGold = a;
    totalSilver = b;
    gold = g.clone();
    silver = s.clone();

    HashMap<Integer, Double> weightPerTimeList = new HashMap<>();
    for (int i = 0; i < t.length; i++) {
      weightPerTimeList.put(i, w[i] * (1.0) / t[i]);
    }
    List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(weightPerTimeList.entrySet());
    entryList.sort((o1, o2) -> compare(o1, o2));

    for (Map.Entry<Integer, Double> entry : entryList) {
      getStone(entry.getKey(), w[entry.getKey()], t[entry.getKey()]);
    }

    return maxTime;
  }

  private static void getStone(int country, int weight, int time) {

    int truckWeight = 0;
    int totalTime = 0;
    int totalStone = totalGold + totalSilver;

    while (totalStone > 0) {
      if (isNotWorking(country)) {
        maxTime = Math.max(maxTime, totalTime);
        return;
      }
      totalTime += time;

      if (totalGold > 0 && gold[country] > 0) {
        int goldWeight = Math.min(Math.min(totalGold, gold[country]), (weight - truckWeight));
        truckWeight += goldWeight;
        gold[country] -= goldWeight;
        totalGold -= goldWeight;
      }

      if (totalSilver > 0 && silver[country] > 0) {
        int silverWeight = Math.min(Math.min(totalSilver, silver[country]), (weight - truckWeight));
        truckWeight += silverWeight;
        silver[country] -= silverWeight;
        totalSilver -= silverWeight;
      }

      if (isNotWorking(country)) {
        maxTime = Math.max(maxTime, totalTime);
        return;
      }
      totalTime += time;
      truckWeight = 0;
      totalStone = totalGold + totalSilver;
    }

    maxTime = Math.max(maxTime, totalTime);

  }

  private static boolean isNotWorking(int country) {
    if (totalGold == 0 && totalSilver == 0) { //옮길 금속이 없을 때
      return true;
    }

    if (totalGold == 0 || totalSilver == 0) { //남은 금속을 옮길 수 없을 때
      if (totalGold > 0 && gold[country] == 0 || totalSilver > 0 && silver[country] == 0) {
        return true;
      }
    }

    if (gold[country] == 0 && silver[country] == 0) {
      return true;
    }
    return false;
  }


  private static int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
    if (o2.getValue() - o1.getValue() > 0) {
      return 1;
    } else {
      return -1;
    }
  }
}
