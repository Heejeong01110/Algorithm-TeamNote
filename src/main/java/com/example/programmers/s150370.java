package com.example.programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class s150370 {

  public static int[] solution(String rawToday, String[] terms, String[] rawPrivacies) {
    String[] sp_today = rawToday.split("\\.");
    Date today = new Date(
        Integer.parseInt(sp_today[0]),
        Integer.parseInt(sp_today[1]),
        Integer.parseInt(sp_today[2]));

    HashMap<String, Integer> termsMonth = new HashMap<>();
    for (String term : terms) {
      String[] sp = term.split(" ");
      termsMonth.put(sp[0], Integer.parseInt(sp[1]));
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < rawPrivacies.length; i++) {
      String[] sp = rawPrivacies[i].split(" ");
      String[] sp_day = sp[0].split("\\.");

      Date day = new Date(Integer.parseInt(sp_day[0]), Integer.parseInt(sp_day[1]),
          Integer.parseInt(sp_day[2]));
      if (isExpired(today, day, termsMonth.get(sp[1]))) {
        ans.add(i + 1);
      }
    }
    int[] answer = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      answer[i] = ans.get(i);
    }

    return answer;
  }

  private static boolean isExpired(Date today, Date day, Integer month) {
    int today_m = today.y * 12 + today.m;
    int day_m = day.y * 12 + day.m;
    return today_m - day_m > month || today_m - day_m == month && today.d >= day.d;
  }

  static class Date {

    int y;
    int m;
    int d;

    public Date(int y, int m, int d) {
      this.y = y;
      this.m = m;
      this.d = d;
    }
  }

}
