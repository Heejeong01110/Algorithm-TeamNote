package com.example.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//셔틀버스
public class s17678 {

  public static String solution(int n, int t, int m, String[] timetable) {
    PriorityQueue<Integer> times = new PriorityQueue<>();

    for (String s : timetable) {
      times.add(stringToTime(s));
    }

    int currentTime = 0;
    int busTime = 9 * 60;
    List[] list = new List[n];

    for (int i = 0; i < n; i++) {
      list[i] = new ArrayList();
      while (!times.isEmpty()) {
        int tmp = times.poll();
        if (tmp <= busTime && list[i].size() < m) {
          list[i].add(tmp);
          currentTime = tmp - 1;
        } else {
          times.add(tmp);
          break;
        }
      }
      busTime += t;
    }

    if (list[n - 1].size() < m) {
      currentTime = busTime - t;
    }

    return timeToString(currentTime);
  }

  static Integer stringToTime(String str) {
    String[] time = str.split(":");
    return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
  }

  static String timeToString(Integer time) {
    String hour = String.format("%02d", time / 60);
    String minute = String.format("%02d", time % 60);
    return hour + ":" + minute;
  }

}
