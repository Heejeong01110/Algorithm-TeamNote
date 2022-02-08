package com.example.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 광고 삽입
public class s72414 {

  private static Integer maxCount;

  public static String solution(String play_time, String adv_time, String[] logs) {
    String answer = "";
    maxCount = Integer.MIN_VALUE;

    ArrayList<TimeTable> times = new ArrayList<>();
    HashMap<Integer, Integer> timeSchedule = new HashMap<>();
    HashMap<Integer, Integer> timeSum = new HashMap<>();

    for (int i = 0; i < logs.length; i++) {
      String[] time = logs[i].split("-");
      CustomTime start = new CustomTime(time[0]);
      CustomTime end = new CustomTime(time[1]);

      times.add(new TimeTable(start, end));
      timeSchedule.put(start.secondTime, timeSchedule.getOrDefault(start.secondTime, 0) + 1);
      timeSchedule.put(end.secondTime, timeSchedule.getOrDefault(end.secondTime, 0) - 1);
    }

    CustomTime advTime = new CustomTime(adv_time);
    CustomTime endTime = new CustomTime(play_time);
//    timeSchedule.put(0, timeSchedule.getOrDefault(0, 0) + 1);
//    timeSchedule.put(endTime.secondTime - advTime.secondTime, timeSchedule.getOrDefault(endTime.secondTime - advTime.secondTime, 0) + 1);

    List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(timeSchedule.entrySet());
    entryList.sort(Comparator.comparingInt(Map.Entry::getKey));

    Integer beforeKey = entryList.get(0).getKey();
    timeSum.put(beforeKey, timeSum.getOrDefault(beforeKey, 0) + entryList.get(0).getValue());

    for (int i = 1; i < entryList.size(); i++) {
      timeSum.put(entryList.get(i).getKey(), timeSum.get(beforeKey) + entryList.get(i).getValue());
      beforeKey = entryList.get(i).getKey();
    }

    List<Map.Entry<Integer, Integer>> entrySumList = new LinkedList<>(timeSum.entrySet());
    entrySumList.sort(Comparator.comparingInt(Map.Entry::getKey));

    for (int i = 0; i < entrySumList.size(); i++) {
      Integer count = getAllPeople(entrySumList, i, entrySumList.get(i).getKey(),
          advTime.secondTime, endTime.secondTime);
      if (maxCount < count) {
        maxCount = count;
        answer = timeToString(entrySumList.get(i).getKey());
      }
    }

    return answer;
  }

  private static String timeToString(Integer time) {
    int hour = time / 3600;
    int minute = (time - hour * 3600) / 60;
    int second = (time - hour * 3600) % 60;

    StringBuilder result = new StringBuilder();
    if (hour < 10) {
      result.append("0").append(hour).append(":");
    } else if (hour == 0) {
      result.append("00").append(":");
    } else {
      result.append(hour).append(":");
    }

    if (minute < 10) {
      result.append("0").append(minute).append(":");
    } else if (minute == 0) {
      result.append("00").append(":");
    } else {
      result.append(minute).append(":");
    }

    if (second < 10) {
      result.append("0").append(second);
    } else if (second == 0) {
      result.append("00");
    } else {
      result.append(second);
    }
    return result.toString();
  }

  private static Integer getAllPeople(List<Map.Entry<Integer, Integer>> entrySumList,
      Integer entryIndex,
      Integer startTime, Integer advTime, Integer endTime) {

    Integer advEndTime = Math.min(startTime + advTime, endTime);
    Integer countTime = 0;

    if (!entrySumList.get(entryIndex).getKey().equals(startTime)) {
      return 0;
    }

    while (startTime < advEndTime) {
      if (entryIndex == entrySumList.size() - 1 || startTime == advEndTime) { //마지막 시간 체크일 때
        break;
      }

      Integer peopleCount = entrySumList.get(entryIndex).getValue();
      Integer partStart = entrySumList.get(entryIndex).getKey();
      Integer partEnd = Math.min(entrySumList.get(entryIndex + 1).getKey(), advEndTime);
      countTime += peopleCount * (partEnd - partStart);
      entryIndex += 1;
      startTime = Math.min(entrySumList.get(entryIndex).getKey(), advEndTime);

    }
    return countTime;
  }

  private static class TimeTable {

    CustomTime start;
    CustomTime end;

    public TimeTable(CustomTime start, CustomTime end) {
      this.start = start;
      this.end = end;
    }

  }

  private static class CustomTime {

    String time;
    int hour;
    int minute;
    int second;
    int secondTime;

    public CustomTime(String time) {
      this.time = time;
      String[] timeSplit = time.split(":");
      this.hour = Integer.parseInt(timeSplit[0]);
      this.minute = Integer.parseInt(timeSplit[1]);
      this.second = Integer.parseInt(timeSplit[2]);
      this.secondTime = hour * 3600 + minute * 60 + second;
    }

  }
}
