package com.example.programmers.exam;

import java.util.ArrayList;
import java.util.HashMap;

public class s250420_3 {

  static int answer;
  static HashMap<String, ArrayList<Integer>> map;

  public static int solution(int a, int b, String[][] bus, String[] arr) {
    answer = Integer.MAX_VALUE;
    map = new HashMap<>();

    for (int i = 0; i < bus.length; i++) {
      for (String now : bus[i]) {
        ArrayList<Integer> busNow = map.getOrDefault(now, new ArrayList<>());
        busNow.add(i);
        map.put(now, busNow);
      }
    }

    bfs(0, 0, -1, a, b, bus, arr);

    return answer;
  }


  private static void bfs(int idx, int cost, int pre, int a, int b, String[][] bus,
      String[] arr) {
    if (idx == arr.length) {
      answer = Math.min(answer, cost);
      return;
    }

    String preStation = idx == 0 ? null : arr[idx - 1];
    String now = arr[idx];
    String nextStation = (idx != arr.length - 1) ? arr[idx + 1] : null;
    ArrayList<Integer> busStations = map.get(now);

    for (int i = 0; i < busStations.size(); i++) {
      //1. 이전 정거장이랑 같은 라인인지 확인
      //2. 다음 정거장이랑 같은 라인인지 확인
      if (idx != 0 && idx != arr.length - 1 && pre != busStations.get(i) && isTransfer(bus, pre,
          preStation, now, busStations.get(i), nextStation)) { //환승
        bfs(idx + 1, cost + b, busStations.get(i), a, b, bus, arr);
      } else { //일반
        bfs(idx + 1, cost + a, busStations.get(i), a, b, bus, arr);
      }
    }
  }

  private static boolean isTransfer(String[][] bus, int preLine, String preStation, String now,
      int nowLine, String nextStation) {
    int[] busStation = new int[]{-1, -1};
    for (int i = 0; i < bus[preLine].length; i++) {
      if (preStation.equals(bus[preLine][i])) {
        busStation[0] = i;
      }

      if (now.equals(bus[preLine][i])) {
        busStation[1] = i;
        break;
      }
    }

    int[] nextBusStation = new int[]{-1, -1};
    for (int i = 0; i < bus[nowLine].length; i++) {
      if (now.equals(bus[nowLine][i])) {
        nextBusStation[0] = i;
      }

      if (nextStation.equals(bus[nowLine][i])) {
        nextBusStation[1] = i;
        break;
      }
    }

    return busStation[0] != -1 && nextBusStation[0] != -1;
  }
}
