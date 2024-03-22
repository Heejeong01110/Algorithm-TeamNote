package com.example.programmers;

import java.util.HashMap;

public class s258712 {

  public static int solution(String[] friends, String[] gifts) {
    HashMap<String, Integer> id = new HashMap<>();
    for (int i = 0; i < friends.length; i++) {
      id.put(friends[i], i);
    }

    int[][] info = new int[friends.length][friends.length];
    int[] info_total = new int[friends.length]; //0:준 선물, 1:받은 선물
    for (int i = 0; i < gifts.length; i++) {
      String[] sp = gifts[i].split(" ");
      int giver = id.get(sp[0]);
      int taker = id.get(sp[1]);
      info[giver][taker] += 1;
      info[taker][giver] -= 1;
      info_total[giver] += 1;
      info_total[taker] -= 1;
    }

    int[] result = new int[friends.length];
    for (int i = 0; i < friends.length; i++) {
      for (int j = i + 1; j < friends.length; j++) {
        if (info[i][j] > 0) {
          result[i] += 1;
        } else if (info[i][j] < 0) {
          result[j] += 1;
        } else if (info_total[i] > info_total[j]) {
          result[i] += 1;
        } else if (info_total[i] < info_total[j]) {
          result[j] += 1;
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < result.length; i++) {
      answer = Math.max(answer, result[i]);
    }

    return answer;
  }
}
